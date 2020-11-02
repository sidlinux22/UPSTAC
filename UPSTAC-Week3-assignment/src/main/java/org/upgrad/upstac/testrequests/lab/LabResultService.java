package org.upgrad.upstac.testrequests.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.upgrad.upstac.testrequests.TestRequest;
import org.upgrad.upstac.users.User;
import java.time.LocalDate;
import javax.transaction.Transactional;

@Service
@Validated
public class LabResultService {


    @Autowired
    private LabResultRepository labResultRepository;


    private static Logger logger = LoggerFactory.getLogger(LabResultService.class);


    private LabResult createLabResult(User tester, TestRequest testRequest) {
        //Implement this method to create the lab result module service
        // create object of LabResult class and use the setter methods to set tester and testRequest details
        LabResult labResult = new LabResult();
        labResult.setTester(tester);
        labResult.setRequest(testRequest);
        // make use of saveLabResult() method to return the LabResult object
        return saveLabResult(labResult); 
    }

    @Transactional
    LabResult saveLabResult(LabResult labResult) {
        return labResultRepository.save(labResult);
    }


    public LabResult assignForLabTest(TestRequest testRequest, User tester) {

        return createLabResult(tester, testRequest);


    }


    public LabResult updateLabTest(TestRequest testRequest, CreateLabResult createLabResult) {

        //Implement this method to update the lab test
        // create an object of LabResult and make use of setters to set Blood Pressure, Comments,
        LabResult updateLabResult = labResultRepository.findByRequest(testRequest).get();
        // HeartBeat, OxygenLevel, Temperature, Result and UpdatedOn values
        updateLabResult.setHeartBeat(createLabResult.getHeartBeat());
        updateLabResult.setOxygenLevel(createLabResult.getOxygenLevel());
        updateLabResult.setTemperature(createLabResult.getTemperature());
        updateLabResult.setResult(createLabResult.getResult());
        updateLabResult.setBloodPressure(createLabResult.getBloodPressure());
        updateLabResult.setComments(createLabResult.getComments());
        updateLabResult.setUpdatedOn(LocalDate.now());
        // make use of the saveLabResult() method to return the object of LabResult
        return saveLabResult(updateLabResult);
     }

}