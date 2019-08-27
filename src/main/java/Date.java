public class Date {

    public String convertDate(String dateString) {
        String[] dateTime = dateString.split(" ");
        String[] date = dateTime[0].split("/");
        return getDay(date[0]) + " of " + getMonth(Integer.parseInt(date[1])) + " "
                + date[2] + ", " + getTime(dateTime[1]);
    }

    public String getDay(String day) {
        if (day.charAt(0) != '1') {
            if (day.charAt(1) == '1') {
                return day + "st";
            } else if (day.charAt(1) == '2') {
                return day + "nd";
            } else if (day.charAt(1) == '3') {
                return day + "rd";
            } else {
                return day + "th";
            }
        } else {
            return day + "th";
        }
    }

    public String getMonth(int month) {
        switch(month) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return null;
        }
    }

    public String getTime(String time) {

        String hour = null;
        String minutes = null;
        String indicator = null;

        if ((time.charAt(0) == '0') || (Integer.parseInt(time.substring(0,2)) <= 12)) {
            System.out.println(time.substring(0,2));
            if (time.charAt(1) == '0') {
                hour = "12";
                minutes = time.substring(2);
            } else {
                hour = String.valueOf(time.charAt(1));
                System.out.println(hour);
                minutes = time.substring(2);
            }
            indicator = "am";
        } else {
            hour = Integer.toString(Integer.parseInt(time.substring(0,2)) - 12);
            System.out.println(hour);
            minutes = time.substring(2);
            indicator = "pm";
        }
        return hour + "." + minutes + indicator;
    }


}
