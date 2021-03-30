package com.erict.businesscomponent.idgenerator;

import java.io.IOException;

import com.erict.architecture.dao.DAOException;

public interface IdGeneratorInterface {
	long getNextId() throws ClassNotFoundException, DAOException, IOException;
}
