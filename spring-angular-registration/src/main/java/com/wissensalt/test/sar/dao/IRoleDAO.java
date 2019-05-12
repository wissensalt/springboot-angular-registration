package com.wissensalt.test.sar.dao;

import com.wissensalt.test.sar.exception.DAOException;
import com.wissensalt.test.sar.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IRoleDAO extends JpaRepository<Role, Long> {

    Role findByName(String p_Name) throws DAOException;

    Role findByCode(String p_Code) throws DAOException;
}
