package com.wissensalt.test.sar.endpoint;

import com.wissensalt.test.sar.exception.EndPointException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

import static com.wissensalt.test.sar.statval.ISarConstant.Path.DASHBOARD;

/**
 * Created on 5/9/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RequestMapping(DASHBOARD)
public interface IDashboardEndPoint {

    ResponseEntity display(Principal p_Principal) throws EndPointException;
}
