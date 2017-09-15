package com.ATM.Service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ATM.dao.NotesDao;

@Service
public class ATMService {

	@Autowired
	NotesDao notesdao;

	public String CheckStatus() {
		HashMap<Integer, Integer> NoteMap = notesdao.retrieveNotesStatus();
		return NoteMap.toString();
	}

	public String retrieveNotes(int amount) {
		HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> NoteMap = notesdao.retrieveNotesStatus();
		result.put(20, 0);
		result.put(50, 0);

		if (amount > NoteMap.get(20) * 20 + NoteMap.get(50) * 50) {
			return "ERROR: Insufficent amount";
		}

		for (int i = 0; i <= NoteMap.get(20); i++) {
			if ((amount - 20 * i) % 50 == 0 && (amount - 20 * i) / 50 <= NoteMap.get(50)) {
				result.put(20, i);
				result.put(50, ((amount - 20 * i) / 50));
				NotesDao.intCount_20 = NotesDao.intCount_20 - i;
				NotesDao.intCount_50 = NotesDao.intCount_50 - ((amount - 20 * i) / 50);
				return result.toString();
			}
		}
		if (result.get(50) == 0 && result.get(20) == 0) {
			return "ERROR : The notes for these amount are not avaliable.";
		}

		return result.toString();
	}

	public String addNotes(Integer denomination, Integer count) {

		if (denomination == 20)
			NotesDao.intCount_20 = NotesDao.intCount_20 + count;
		else if (denomination == 50)
			NotesDao.intCount_50 = NotesDao.intCount_50 + count;

		/*
		 * HashMap<Integer, Integer> NoteMap = notesdao; if (null !=
		 * NoteMap.get(denomination)) { NoteMap.put(denomination,
		 * NoteMap.get(denomination) + count); } else {
		 * NoteMap.put(denomination, count); }
		 */
		return "Notes Added Succesfully";
	}

	public String removeNotes(Integer denomination, Integer count) {
		if (denomination == 20 && NotesDao.intCount_20 >= count) {
			NotesDao.intCount_20 = NotesDao.intCount_20 - count;
			return "Notes Removed Succesfully";
		} else if (denomination == 50 && NotesDao.intCount_50 >= count) {
			NotesDao.intCount_50 = NotesDao.intCount_50 - count;
			return "Notes Removed Succesfully";
		} else {
			return "No Notes to be removed";
		}
	}
}
