package com.wissensalt.test.sar.dao;

import com.wissensalt.test.sar.exception.DAOException;
import com.wissensalt.test.sar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IUserDAO extends JpaRepository<User, Long> {

    User findByMobileNumber(String p_MobileNumber) throws DAOException;

    User findByEmail(String p_Email) throws DAOException;

    User findByCodeAndStatus(String p_Code, Boolean p_Status)throws DAOException;

    User findByCodeOrEmail(String p_Code, String p_Email) throws DAOException;
}
