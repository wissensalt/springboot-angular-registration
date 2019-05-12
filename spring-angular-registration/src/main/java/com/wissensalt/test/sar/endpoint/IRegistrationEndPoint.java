package com.wissensalt.test.sar.endpoint;

import com.wissensalt.test.sar.dto.RequestRegistrationDTO;
import com.wissensalt.test.sar.exception.EndPointException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IRegistrationEndPoint {

    ResponseEntity register(@RequestBody RequestRegistrationDTO p_Request) throws EndPointException;
}
