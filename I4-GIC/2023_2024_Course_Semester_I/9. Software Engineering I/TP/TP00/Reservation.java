package TP00;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
public class Reservation{
    //TP00.1. Reservation class
    // Create the Reservation class, which represents the room
    //reservation at departement. This class will contain 
    //information such as room number, person name who make reservation
    //date and time start and end of reservation, and other remarks as a string
    private String roomNumber;
    private String personName;
    private Date startTime;
    private Date endTime;
    private String Remark;

    // TP00.2. Constructor
    // Add 3 constructors to the Reservation class created above.
    public Reservation(String roomNumber, String personName, Date startTime, Date endTime, String Remark){
        setRoomNumber(roomNumber);
        setPersonName(personName);
        setStartTime(startTime);
        setEndTime(endTime);
        this.Remark = Remark;
    }

    public Reservation (String roomNumber, String personName, Date startTime, Date endTime){
   this(roomNumber, personName, startTime, endTime, "");    }

      public Reservation(String roomNumber, String personName, Date startTime){
        setRoomNumber(roomNumber);
        setPersonName(personName);
        setEndTime(startTime);
        Calendar cal = Calendar.getInstance();
        cal.setTime(startTime);
        cal.add(Calendar.HOUR, 2);
        this.endTime = cal.getTime();
        this.Remark ="";
      }


// Add or generate getters and setters to class Reservation created above
      public String getRoomNumber() {
        return roomNumber;
      }

      public void setRoomNumber(String roomNumber) {
         if (roomNumber == null || roomNumber.isEmpty()) {
      throw new IllegalArgumentException("Room number cannot be empty");  
    }
    if (!roomNumber.matches("[A-Za-z]-\\d{3}")) {
      throw new IllegalArgumentException("Room number must start with letter followed by dash and 3 numbers");
    }
          this.roomNumber = roomNumber;  
      }

      public String getPersonName() {
    
        return personName;
      }

      public void setPersonName(String personName) {
        if (personName == null || personName.isEmpty()) {
          throw new IllegalArgumentException("Person name cannot be empty");
        }
        if (!personName.matches(".*[aeiouAEIOU].*") || !personName.matches(".*[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ].*")) {
          throw new IllegalArgumentException("Person name must contain vowels and consonants");
        }
        this.personName = personName;
      }

      public Date getStartTime() {
        return startTime;
      }

      public void setStartTime(Date startTime) {
       Date now = new Date();
       if(startTime.after(now)) this.startTime = startTime;
        else throw new IllegalArgumentException("Start time date must be in the future.");     
      }

      public Date getEndTime() {
        return endTime;
      }

      public void setEndTime(Date endTime) {
         Calendar cal = Calendar.getInstance();
        cal.setTime(startTime);
        cal.add(Calendar.HOUR, 1);
        Date startTimeDate = cal.getTime();
        if(endTime.after(startTimeDate)) this.endTime = endTime;
        else throw new IllegalArgumentException("End time date must be greater than start time at least 1 hour.");
      }

      public String getRemark() {
        return Remark;
      }

      public void setRemark(String remark) {
        Remark = remark;
      }

//       TP00.4. Validations with Exception 
// Add validations to setters of Reservation class created above. The validations include: 
// 1. Room number must not be empty and must start with a letter follows by dash and 3 numbers. Ex: F-209, 
// J-704, … 
// 2. Reservation person’s name must not be empty and must contains vowels and consonants. 
// 3. Reservation date time start must be in the future. 
// 4. Reservation date time end must be greater than date time start at least an hour. 
// 5. Update the constructors to use setters instead of this… = …; 


// TP00.5. Va 
// Create a java program that can: 
// 1. List all reservations. 
// 2. Add new reservation. Reservation date and time must be expressed as a future time. 
// 3. Cancel/remove reservation. A Reservation can be canceled/removed if and only if it is not yet started. 
// 4. Update reservation if it is not yet started. 
// 5. Swap room between 2 reservations of the same date and time reservation
 
    
    }

