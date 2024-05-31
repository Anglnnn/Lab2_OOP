package com.example.testest.service.data;

import com.example.testest.configuration.KeycloakManager;
import com.example.testest.configuration.KeycloakProperties;
import com.example.testest.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
/*
@Service
@RequiredArgsConstructor
public class KeycloakService implements KeycloakRepository {

    private final KeycloakProperties keycloakProperties;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        return keycloakManager.getKeycloakInstanceWithRealm().users().create(userRepresentation).getStatus();
    }

    @Override
    public List<UserRepresentation> readUserByEmail(String emailId) {
        return keycloakManager.getKeycloakInstanceWithRealm().users().search(emailId);
    }

    @Override
    public List<UserRepresentation> readUsers(List<String> authIds) {
        return authIds.stream().map(authId-> {
            UserResource usersResource = keycloakManager.getKeycloakInstanceWithRealm().users().get(authId);
            return usersResource.toRepresentation();
        }).collect(Collectors.toList());
    }

    @Override
    public UserRepresentation readUser(String authId) {
        UserResource userResource = keycloakManager.getKeycloakInstanceWithRealm().users().get(authId);
        return userResource.toRepresentation();
    }

    @Override
    public void updateUser(UserRepresentation userRepresentation) {
        keycloakManager.getKeycloakInstanceWithRealm().users()
                .get(userRepresentation.getId()).update(userRepresentation);
    }
}*/
