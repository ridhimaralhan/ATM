package com.ATM.Service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.ATM.dao.NotesDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class ATMServiceTest extends AbstractJUnit4SpringContextTests {

	@Mock
	NotesDao notesdao;

	@InjectMocks
	ATMService atmServiceimpl;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void Test_retrunNotes_50() throws Exception {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		hs.put(50, 10);
		hs.put(20, 2);

		HashMap<Integer, Integer> expectedresult = new HashMap<Integer, Integer>();
		expectedresult.put(50, 1);
		expectedresult.put(20, 0);
		when(notesdao.retrieveNotesStatus()).thenReturn(hs);
		assertEquals(expectedresult.toString(), atmServiceimpl.retrieveNotes(50));

	}

	@Test
	public void Test_retrunNotes_20() throws Exception {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		hs.put(50, 10);
		hs.put(20, 2);

		HashMap<Integer, Integer> expectedresult = new HashMap<Integer, Integer>();
		expectedresult.put(50, 0);
		expectedresult.put(20, 1);
		when(notesdao.retrieveNotesStatus()).thenReturn(hs);
		assertEquals(expectedresult.toString(), atmServiceimpl.retrieveNotes(20));

	}

	@Test
	public void Test_retrunNotes_40() throws Exception {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		hs.put(50, 10);
		hs.put(20, 2);

		HashMap<Integer, Integer> expectedresult = new HashMap<Integer, Integer>();
		expectedresult.put(50, 0);
		expectedresult.put(20, 2);
		when(notesdao.retrieveNotesStatus()).thenReturn(hs);
		assertEquals(expectedresult.toString(), atmServiceimpl.retrieveNotes(40));

	}

	@Test
	public void Test_retrunNotes_70() throws Exception {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		hs.put(50, 10);
		hs.put(20, 2);

		HashMap<Integer, Integer> expectedresult = new HashMap<Integer, Integer>();
		expectedresult.put(50, 1);
		expectedresult.put(20, 1);
		when(notesdao.retrieveNotesStatus()).thenReturn(hs);
		assertEquals(expectedresult.toString(), atmServiceimpl.retrieveNotes(70));

	}

	@Test
	public void Test_retrunNotes_80() throws Exception {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		hs.put(50, 10);
		hs.put(20, 4);

		HashMap<Integer, Integer> expectedresult = new HashMap<Integer, Integer>();
		expectedresult.put(50, 0);
		expectedresult.put(20, 4);
		when(notesdao.retrieveNotesStatus()).thenReturn(hs);
		assertEquals(expectedresult.toString(), atmServiceimpl.retrieveNotes(80));

	}

	@Test
	public void Test_retrunNotes_100() throws Exception {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		hs.put(50, 10);
		hs.put(20, 2);

		HashMap<Integer, Integer> expectedresult = new HashMap<Integer, Integer>();
		expectedresult.put(50, 2);
		expectedresult.put(20, 0);
		when(notesdao.retrieveNotesStatus()).thenReturn(hs);
		assertEquals(expectedresult.toString(), atmServiceimpl.retrieveNotes(100));

	}

	@Test
	public void Test_retrunNotes_150() throws Exception {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		hs.put(50, 10);
		hs.put(20, 2);

		HashMap<Integer, Integer> expectedresult = new HashMap<Integer, Integer>();
		expectedresult.put(50, 3);
		expectedresult.put(20, 0);
		when(notesdao.retrieveNotesStatus()).thenReturn(hs);
		assertEquals(expectedresult.toString(), atmServiceimpl.retrieveNotes(150));

	}

	@Test
	public void Test_retrunNotes_60() throws Exception {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		hs.put(50, 10);
		hs.put(20, 3);

		HashMap<Integer, Integer> expectedresult = new HashMap<Integer, Integer>();
		expectedresult.put(50, 0);
		expectedresult.put(20, 3);
		when(notesdao.retrieveNotesStatus()).thenReturn(hs);
		assertEquals(expectedresult.toString(), atmServiceimpl.retrieveNotes(60));

	}

	@Test
	public void Test_retrunNotes_110() throws Exception {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		hs.put(50, 10);
		hs.put(20, 3);

		HashMap<Integer, Integer> expectedresult = new HashMap<Integer, Integer>();
		expectedresult.put(50, 1);
		expectedresult.put(20, 3);
		when(notesdao.retrieveNotesStatus()).thenReturn(hs);
		assertEquals(expectedresult.toString(), atmServiceimpl.retrieveNotes(110));

	}

	@Test
	public void Test_retrunNotes_200() throws Exception {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		hs.put(50, 3);
		hs.put(20, 8);

		HashMap<Integer, Integer> expectedresult = new HashMap<Integer, Integer>();
		expectedresult.put(50, 2);
		expectedresult.put(20, 5);
		when(notesdao.retrieveNotesStatus()).thenReturn(hs);
		assertEquals(expectedresult.toString(), atmServiceimpl.retrieveNotes(200));

	}
	
	@Test
	public void Test_retrunNotes_90() throws Exception {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		hs.put(50, 1);
		hs.put(20, 1);

		
		when(notesdao.retrieveNotesStatus()).thenReturn(hs);
		assertEquals("ERROR: Insufficent amount", atmServiceimpl.retrieveNotes(90));

	}
	
	@Test
	public void Test_retrunNotes_NoNotes() throws Exception {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		hs.put(50, 0);
		hs.put(20, 0);		
		when(notesdao.retrieveNotesStatus()).thenReturn(hs);
		assertEquals("ERROR: Insufficent amount", atmServiceimpl.retrieveNotes(80));

	}
	
	@Test
	public void Test_retrunNotes_110_noNotes() throws Exception {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		hs.put(50, 3);
		hs.put(20, 0);		
		when(notesdao.retrieveNotesStatus()).thenReturn(hs);
		assertEquals("ERROR : The notes for these amount are not avaliable.", atmServiceimpl.retrieveNotes(110));

	}
	
	@Test
	public void Test_addNotes() throws Exception {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		hs.put(50, 3);
		hs.put(20, 0);		
		when(notesdao.retrieveNotesStatus()).thenReturn(hs);		
		assertEquals("Notes Added Succesfully", atmServiceimpl.addNotes(20, 2));

	}
	
	@Test
	public void Test_removeNotes() throws Exception {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		hs.put(50, 3);
		hs.put(20, 0);		
		when(notesdao.retrieveNotesStatus()).thenReturn(hs);		
		assertEquals("Notes Removed Succesfully", atmServiceimpl.removeNotes(50, 2));

	}

}
