package edu.nyu.cs.pqs.addressbooklibrary;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Represents an Address book library that can be used to create an entry, delete an entry
 * and search by the various properties of an address entry.
 *  
 * @author Aishwarya Thyagarajan
 * @version 1.0
 *
 */
public class AddressBook {
	
	private List<AddressBookEntry> entries;
	
	public AddressBook(){
		entries = new ArrayList<AddressBookEntry>();
	}
	
	/**
	 * Add a new entry into the address book
	 * 
	 * @param entry The entry cannot be null
	 * @return true if the entry got added successfully, otherwise false
	 */
	public boolean addEntry(AddressBookEntry entry){
		if (entry == null)
			throw new NullPointerException();
		AddressBookEntry newEntry = entry.clone();
		return entries.add(newEntry);
	}
	
	/**
	 * Delete an entry from the address book 
	 * 
	 * @param entry The entry to be removed cannot be null
	 * @return true if the entry got removed successfully, otherwise returns false
	 */
	public boolean deleteEntry(AddressBookEntry entry){
		if(entry == null)
			throw new NullPointerException();
		return entries.remove(entry);
	}

	/**
	 * Search the address book for an entry by the name property
	 * 
	 * @param name The name cannot be null nor can it be an empty string
	 * @return null, if nothing is found otherwise the matching address book entry is returned
	 */
	public AddressBookEntry searchByName(String name){
		if(name == null || name.length() == 0)
			throw new IllegalArgumentException();
		for (AddressBookEntry entry : entries){
			if(entry.getName().compareTo(name) == 0)
				return entry;
		}
		return null;
	}
	
	/**
	 * Search the address book for an entry by the postal address property
	 * 
	 * @param postalAddress The postal address cannot be null
	 * @return null, if nothing is found otherwise the matching address book entry is returned
	 */
	public AddressBookEntry searchByPostalAddress(String postalAddress){
		if(postalAddress == null)
			throw new IllegalArgumentException();
		for (AddressBookEntry entry : entries){
			if(entry.getPostalAddress().compareTo(postalAddress) == 0)
				return entry;
		}
		return null;
	}
	
	/**
	 * Search the address book for an entry by the phone number property
	 * 
	 * @param phoneNumber The phone number cannot be null
	 * @return null, if nothing is found otherwise the matching address book entry is returned
	 */
	public AddressBookEntry searchByPhoneNumber(String phoneNumber){
		if(phoneNumber == null)
			throw new IllegalArgumentException();
		for (AddressBookEntry entry : entries){
			if(entry.getPhoneNumber().compareTo(phoneNumber) == 0)
				return entry;
		}
		return null;
	}
	
	/**
	 * Search the address book for an entry by the email address property
	 * 
	 * @param emailAddress The email address cannot be null
	 * @return null, if nothing is found otherwise the matching address book entry is returned
	 */
	public AddressBookEntry searchByEmailAddress(String emailAddress){
		if(emailAddress == null)
			throw new IllegalArgumentException();
		for (AddressBookEntry entry : entries){
			if(entry.getEmailAddress().compareTo(emailAddress) == 0)
				return entry;
		}
		return null;
	}
	
	/**
	 * Search the address book for an entry by the note property
	 * 
	 * @param note The note cannot be null
	 * @return null, if nothing is found otherwise the matching address book entry is returned
	 */
	public AddressBookEntry searchByNote(String note){
		if(note == null)
			throw new IllegalArgumentException();
		for (AddressBookEntry entry : entries){
			if(entry.getNote().compareTo(note) == 0)
				return entry;
		}
		return null;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entries == null) ? 0 : entries.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressBook other = (AddressBook) obj;
		if (entries == null) {
			if (other.entries != null)
				return false;
		} else if (!entries.equals(other.entries))
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		String addressBookEntries = "";
		for(AddressBookEntry entry: entries)
			addressBookEntries += entry.toString();
		return addressBookEntries;
	}
}
