package edu.nyu.cs.pqs.addressbooklibrary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Helper class of the AddressBook class that can both save the address book from memory and load it back into memory.
 * 
 * @author Aishwarya Thyagarajan
 * @version 1.0
 *
 */
public class AddressBookUtils {
	
	/**
	 * Save the address book from the memory into a file
	 * 
	 * @param addressBook The source address book in memory that needs to be saved
	 * @param outputStream The destination output stream (generic output stream so that it's not limited to files but with streams in general).
	 * 					   The validity of output stream can be checked by the client.
	 * @throws Exception could be thrown while writing
	 */
	public static final void save(AddressBook addressBook, OutputStream outputStream) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
		bw.write(addressBook.toString());
		bw.close();
	}

	/**
	 * Load the address book from the file into memory
	 * 
	 * @param inputStream The source input stream (generic input stream to allow all kinds of streams) from where address book entries need to be read.
	 *                    The validity of input stream can be checked by the client.
	 * @param addressBook The destination address book in memory
	 * @throws Exception Exceptions can be thrown during writing
	 */
	public static final void load(InputStream inputStream, AddressBook addressBook) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		String nextLine = br.readLine();
		while (nextLine != null) {
			//"**********" marks the end of an entry
			if (nextLine.compareTo("**********") == 0)
				nextLine = br.readLine();
			if (nextLine == null)
				break;
			String name = nextLine;
			String postalAddress = br.readLine();
			String phoneNumber = br.readLine();
			String emailAddress = br.readLine();
			String note = br.readLine();
			//Use the builder pattern to construct the entry from each of the properties
			AddressBookEntry entry = new AddressBookEntry.Builder(name)
									 .postalAddress(postalAddress)
									 .phoneNumber(phoneNumber)
									 .emailAddress(emailAddress)
									 .note(note)
									 .build();
			addressBook.addEntry(entry);
			nextLine = br.readLine();
		}
		br.close();
	}

}
