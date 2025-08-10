package com.example.NetConnect.service;

import com.example.NetConnect.constants.MessageConstants;
import com.example.NetConnect.repository.UserRepo;
import com.example.NetConnect.utils.CommonResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepo userRepo;

    public ResponseEntity<?> checkOrGenerateUserName(String userName){
        CommonResponseObject commonResponseObject = new CommonResponseObject();
        CommonResponseObject.buildFailureResponse(commonResponseObject,MessageConstants.SERVER_ERROR,HttpStatus.CONFLICT);
        try{
            String baseUsername = userName.replaceAll("[^a-zA-Z0-9_]", "").toLowerCase();

            if (userRepo.countByUserName(baseUsername) <= 0) {
                CommonResponseObject.buildSuccessResponse(commonResponseObject, MessageConstants.DATA_FOUND_SUCCESSFULLY, Collections.singletonList(baseUsername), HttpStatus.ACCEPTED);
                return new ResponseEntity<>(commonResponseObject,HttpStatus.ACCEPTED);
            }

            // Find the last similar username in DB
            String lastUsername = userRepo.findLastSimilarUsername(baseUsername + "%");

            // Extract the number suffix from the last existing username
            String numberPart = lastUsername.substring(baseUsername.length());
            int nextNumber = 1;
            if (!numberPart.isEmpty() && numberPart.matches("\\d+")) {
                nextNumber = Integer.parseInt(numberPart) + 1;
            }
            CommonResponseObject.buildSuccessResponse(commonResponseObject, MessageConstants.DATA_FOUND_SUCCESSFULLY, Collections.singletonList(baseUsername+nextNumber), HttpStatus.ACCEPTED);
            return new ResponseEntity<>(commonResponseObject,HttpStatus.ACCEPTED);
        }catch (Exception e){
            log.error("Error in checkOrGenerateName() : {}",e.getMessage());
            commonResponseObject.setMessage(e.getMessage());
            return new ResponseEntity<>(commonResponseObject,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
