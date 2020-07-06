package com.ucmo.service;

import java.util.List;

import com.ucmo.dto.Program;
import com.ucmo.dto.RequestInputs;

public interface RequestInputsService {
	
	public List<RequestInputs> getAllRequestInputs(List<Program> programsList);	
	public List<RequestInputs> getAllSessionInputs(List<Program> programsList);
	public List<RequestInputs> getAllHistoryInputs(List<Program> programsList);

}
