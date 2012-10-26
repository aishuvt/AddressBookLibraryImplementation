package edu.nyu.cs.pqs.addressbooklibrary;

import java.util.regex.Pattern;

/**
 * Address Book Entry having Name,Postal Address, Phone Number, Email Address and Note properties
 * 		
 * @author Aishwarya Thyagarajan
 * @version 1.0
 *
 */
public class AddressBookEntry implements Cloneable{
	private String name;
	private String postalAddress;
	private String phoneNumber;
	private String emailAddress;
	private String note;
	
	public static class Builder{
		private String name;
		private String postalAddress = "";
		private String phoneNumber = "";
		private String emailAddress = "";
		private String note = "";
		
		/* Regular expression to check phone number's format: optionalCountryCode-xxx-xxx-xxxx 
		   Examples: 1-234-567-8901, 234-567-8901, (234) 567 8901 */
		private static final String phoneNumberRegEx = "^(\\d{1,4}-)?\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
		//Regular expression to check email address's format: username@domain-name
		private static final String emailAddressRegEx = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		
		/**
		 * Builder pattern for the name (required) parameter
		 * 
		 * @param name name cannot be null, neither can it be empty
		 */
		public Builder(String name){
			if(name == null)
				throw new NullPointerException();
			if (name.length() == 0)
				throw new IllegalArgumentException();
			this.name = name;
		}
		
		/**
		 * Builder pattern for the postal address (optional) parameter
		 * 
		 * @param val postal address cannot be null, but can be an empty string
		 * @return an instance of the Builder class
		 */
		public Builder postalAddress(String val){
			if(val == null)
				throw new NullPointerException();
			postalAddress = val;
			return this;
		}
		
		/**
		 * Builder pattern for phone number (optional) parameter
		 * 
		 * @param val phone number cannot be null, but can be an empty string and should be of a valid format (optionalCountryCode-xxx-xxx-xxxx)
		 * @return an instance of the Builder class
		 */
		public Builder phoneNumber(String val){
			if(val == null)
				throw new NullPointerException();
			if(checkPhoneNumber(val))
				phoneNumber = val;
			else throw new IllegalArgumentException();
			return this;
		}
		
		/**
		 * Checks the validity of the phone number
		 * 
		 * @param val phone number
		 * @return true if the phone number is of the valid format, otherwise returns false
		 */
		public static boolean checkPhoneNumber(String val) {
			String inputString = val;
			Pattern pattern = Pattern.compile(phoneNumberRegEx);
			if (pattern.matcher(inputString).matches()) 
				return true;
			return false;
		}
		
		/**
		 * Builder pattern for email address (optional) parameter
		 * 
		 * @param val email address cannot be null, but can be an empty string and should be of a valid format (username@domain-name)
		 * @return an instance of the Builder class
		 */
		public Builder emailAddress(String val){
			if(val == null)
				throw new NullPointerException();
			if(checkEmailAddress(val))
				emailAddress = val;
			else throw new IllegalArgumentException();
			return this;
		}
		
		/**
		 * Checks the validity of the email address
		 * 
		 * @param val email address 
		 * @return true if the email address is of the valid format, otherwise returns false
		 */
		public static boolean checkEmailAddress(String val) {
			CharSequence inputString = val;
			Pattern pattern = Pattern.compile(emailAddressRegEx,Pattern.CASE_INSENSITIVE);
			if (pattern.matcher(inputString).matches())
				return true;
			return false;
		}
		
		/**
		 * Builder pattern for note (optional) parameter
		 * 
		 * @param val note cannot be null, but can be an empty string
		 * @return an instance of the Builder class
		 */
		public Builder note(String val){
			if(val == null)
				throw new NullPointerException();
			note = val;
			return this;
		}
		
		/**
		 * Builder pattern for multi-parameter constructor
		 * 
		 * @return an instance of AddressBookEntry
		 */
		public AddressBookEntry build(){
			return new AddressBookEntry(this);
		}
	}
	
	private AddressBookEntry(Builder builder){
		name = builder.name;
		postalAddress = builder.postalAddress;
		phoneNumber = builder.phoneNumber;
		emailAddress = builder.emailAddress;
		note = builder.note;
	}
	
	/**
	 * Setter for entry's name 
	 * @param val name cannot be null nor an empty string
	 */
	public void setName(String val) {
		if (val == null)
			throw new NullPointerException();
		if (val.length() == 0)
			throw new IllegalArgumentException();
		name = val;
	}
	
	/**
	 * Setter for entry's postal address
	 * @param val postal address cannot be null, but can be an empty string
	 */
	public void setPostalAddress(String val) {
		if (val == null)
			throw new NullPointerException();
		postalAddress = val;
	}
	
	/**
	 * Setter for entry's phone number
	 * @param val phone number cannot be null, but can be an empty string and must be of a valid format (optionalCountryCode-xxx-xxx-xxxx)
	 */
	public void setPhoneNumber(String val) {
		if (val == null)
			throw new NullPointerException();
		if (Builder.checkPhoneNumber(val)) {
			phoneNumber = val;
		} else
			throw new IllegalArgumentException();
	}
	
	/**
	 * Setter for entry's email address
	 * @param val email address cannot be null, but can be an empty string and must be of a valid format (username@domain name)
	 */
	public void setEmailAddress(String val) {
		if (val == null)
			throw new NullPointerException();
		if (Builder.checkEmailAddress(val)) {
			emailAddress = val;
		} else
			throw new IllegalArgumentException();
	}

	/**
	 * Setter for entry's note
	 * @param val note cannot be null, but can be an empty string
	 */
	public void setNote(String val) {
		if (val == null)
			throw new NullPointerException();
		note = val;
	}
	
	/**
	 * Getter for entry's name property
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter for entry's postal address
	 * @return postal address
	 */
	public String getPostalAddress() {
		return postalAddress;
	}

	
	/**
	 * Getter for entry's phone number
	 * @return phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Getter for entry's email address
	 * @return email address
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	
	/**
	 * Getter for entry's note
	 * @return note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * 
	 * @param val a string for comparing with entry's name
	 * @return true if the string matches with the entry's name, otherwise returns false
	 */
	private boolean compareName(String val) {
		if (this.name.compareTo(val) == 0)
			return true;
		return false;
	}

	/**
	 * 
	 * @param val a string for comparing with entry's postal address
	 * @return true if the string matches with the entry's postal address, otherwise returns false
	 */
	private boolean comparePostalAddress(String val) {
		if (this.postalAddress.compareTo(val) == 0)
			return true;
		return false;
	}

	/**
	 * 
	 * @param val a string for comparing with entry's phone number
	 * @return true if the string matches with the entry's phone number, otherwise returns false
	 */
	private boolean comparePhoneNumber(String val) {
		if (this.phoneNumber.compareTo(val) == 0)
			return true;
		return false;
	}

	/**
	 * 
	 * @param val a string for comparing with entry's email address
	 * @return true if the string matches with the entry's email address, otherwise returns false
	 */
	private boolean compareEmailAddress(String val) {
		if (this.emailAddress.compareTo(val) == 0)
			return true;
		return false;
	}

	/**
	 * 
	 * @param val a string for comparing with entry's note
	 * @return true if the string matches with the entry's note, otherwise returns false
	 */
	private boolean compareNote(String val) {
		if (this.note.compareTo(val) == 0)
			return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof AddressBookEntry))
			return false;
		AddressBookEntry entry = (AddressBookEntry) o;
		return compareName(entry.name) 
			&& comparePostalAddress(entry.postalAddress)
		    && comparePhoneNumber(entry.phoneNumber)
		    && compareEmailAddress(entry.emailAddress) 
		    && compareNote(entry.note);
	}

	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = result * prime + name.hashCode();
		result = result * prime + postalAddress.hashCode();
		result = result * prime + phoneNumber.hashCode();
		result = result * prime + emailAddress.hashCode();
		result = result * prime + note.hashCode();
		return result;
	}

	@Override
	public String toString() {
		//"**********" marks the end of an entry
		return name + "\r\n" + postalAddress + "\r\n" + phoneNumber + "\r\n"
		    + emailAddress + "\r\n" + note + "\r\n" + "**********" + "\r\n";
	}
	
	@Override
	public AddressBookEntry clone() {
		try {
			AddressBookEntry abEntry = (AddressBookEntry) super.clone();
			abEntry.setName(name);
			abEntry.setPostalAddress(postalAddress);
			abEntry.setPhoneNumber(phoneNumber);
			abEntry.setEmailAddress(emailAddress);
			abEntry.setNote(note);
			return abEntry;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

}
