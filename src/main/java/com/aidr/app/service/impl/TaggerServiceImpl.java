package com.aidr.app.service.impl;

import com.aidr.app.dto.*;
import com.aidr.app.exception.AidrException;
import com.aidr.app.service.TaggerService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.MediaType;
import java.util.List;

@Service("taggerService")
public class TaggerServiceImpl implements TaggerService {

    private Logger logger = Logger.getLogger(getClass());
    @Autowired
    private Client client;
    @Value("${taggerMainUrl}")
    private String taggerMainUrl;

    public List<TaggerCrisisType> getAllCrisisTypes() throws AidrException{
        try {
            /**
             * Rest call to Tagger
             */
            WebResource webResource = client.resource(taggerMainUrl + "/crisisType/all");
            ObjectMapper objectMapper = new ObjectMapper();
            ClientResponse clientResponse = webResource.type(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .get(ClientResponse.class);
            String jsonResponse = clientResponse.getEntity(String.class);

            TaggerAllCrisesTypesResponse crisesTypesResponse = objectMapper.readValue(jsonResponse, TaggerAllCrisesTypesResponse.class);
            if (crisesTypesResponse.getCrisisTypes() != null) {
                logger.info("Tagger returned " + crisesTypesResponse.getCrisisTypes().size() + " crises types");
            }

            return crisesTypesResponse.getCrisisTypes();
        } catch (Exception e) {
            throw new AidrException("Error While Getting All Crisis from Tagger", e);
        }
    }

    public List<TaggerCrisis> getCrisesByUserId(Integer userId) throws AidrException{
        try {
            /**
             * Rest call to Tagger
             */
            WebResource webResource = client.resource(taggerMainUrl + "/crisis?userID=" + userId);
            ObjectMapper objectMapper = new ObjectMapper();
            ClientResponse clientResponse = webResource.type(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .get(ClientResponse.class);
            String jsonResponse = clientResponse.getEntity(String.class);

            TaggerAllCrisesResponse taggerAllCrisesResponse = objectMapper.readValue(jsonResponse, TaggerAllCrisesResponse.class);
            if (taggerAllCrisesResponse.getCrisises() != null) {
                logger.info("Tagger returned " + taggerAllCrisesResponse.getCrisises().size() + " crisis for user");
            }

            return taggerAllCrisesResponse.getCrisises();
        } catch (Exception e) {
            throw new AidrException("Error While Getting all crisis for user in Tagger", e);
        }
    }


    public String createNewCrises(TaggerCrisisRequest crisis) throws AidrException {
        try {
            /**
             * Rest call to Tagger
             */
            WebResource webResource = client.resource(taggerMainUrl + "/crisis");
            ObjectMapper objectMapper = new ObjectMapper();

            ClientResponse clientResponse = webResource.type(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .post(ClientResponse.class, objectMapper.writeValueAsString(crisis));

            return clientResponse.getEntity(String.class);
        } catch (Exception e) {
            throw new AidrException("Error While Getting collections running for user in Tagger", e);
        }
    }

}
