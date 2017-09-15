package com.ATM.dao;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class NotesDao {

	public static int intCount_20 =0; ;
	public static int intCount_50 =10;
	
	public HashMap<Integer, Integer> retrieveNotesStatus() {
		HashMap<Integer, Integer> NoteMap = new HashMap<Integer, Integer>();
		NoteMap.put(20, intCount_20);
		NoteMap.put(50, intCount_50);
		return NoteMap;
	
}
}
