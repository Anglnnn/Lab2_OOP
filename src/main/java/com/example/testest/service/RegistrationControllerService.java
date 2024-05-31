package com.example.testest.service;

import com.example.testest.configuration.KeycloakProperties;
import com.example.testest.converter.UserConverter;
import com.example.testest.dto.UserDTO;
import com.example.testest.entity.Cart;
import com.example.testest.entity.User;
import com.example.testest.service.data.CartService;
import com.example.testest.service.data.RegistrationService;
import javax.ws.rs.core.Response;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RegistrationControllerService {

    private final UserConverter userConverter;
    private final RegistrationService registrationService;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final CartService cartService;
    private final KeycloakProperties keycloakProperties;

    public RegistrationControllerService(UserConverter userConverter,
                                         RegistrationService registrationService,
                                         ApplicationEventPublisher applicationEventPublisher,
                                         CartService cartService,
                                         KeycloakProperties keycloakProperties){
        this.userConverter = userConverter;
        this.registrationService = registrationService;
        this.applicationEventPublisher = applicationEventPublisher;
        this.cartService = cartService;
        this.keycloakProperties = keycloakProperties    ;
    }

    public UserDTO save(UserDTO userDTO){
        User currentUser = userConverter.convertToEntity(userDTO);
        UserDTO savedUserDto = userConverter.convertToDto(registrationService.save(currentUser));
        savedUserDto.setPassword(userDTO.getPassword());

        Cart newCart = cartService.createCartForUser(currentUser);

        applicationEventPublisher.publishEvent(savedUserDto);

        return savedUserDto;
    }
}
