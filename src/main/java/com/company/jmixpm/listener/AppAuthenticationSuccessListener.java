package com.company.jmixpm.listener;

import com.company.jmixpm.security.FullAccessRole;
import io.jmix.core.session.SessionData;
import io.jmix.security.role.assignment.RoleAssignment;
import io.jmix.security.role.assignment.RoleAssignmentRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListener;

@Component
public class AppAuthenticationSuccessListener {

    private final ObjectProvider<SessionData> sessionDataProvider;
    private final RoleAssignmentRepository roleAssignmentRepository;

    public AppAuthenticationSuccessListener(ObjectProvider<SessionData> sessionDataProvider,
                                            RoleAssignmentRepository roleAssignmentRepository) {
        this.sessionDataProvider = sessionDataProvider;
        this.roleAssignmentRepository = roleAssignmentRepository;
    }

    @EventListener
    public void onInteractiveAuthenticationSuccess(final InteractiveAuthenticationSuccessEvent event) {
        SessionData sessionData = sessionDataProvider.getIfAvailable();
        if (sessionData != null) {
            UserDetails userDetails = (UserDetails) event.getAuthentication().getPrincipal();
            RoleAssignment fullAccessAssignment = roleAssignmentRepository
                    .getAssignmentsByUsername(userDetails.getUsername())
                    .stream().filter(ra -> ra.getRoleCode().equals(FullAccessRole.CODE))
                    .findFirst()
                    .orElse(null);
            sessionData.setAttribute("isManager", fullAccessAssignment != null);
        }
    }
}