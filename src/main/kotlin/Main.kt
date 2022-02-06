import java.io.File
import java.io.BufferedReader

val informationlist = ArrayList<Person>()
var Firstname: String = null.toString()
var Surname: String = null.toString()
var Phonenumber: String = null.toString()
var Email: String = null.toString()
var choice: String = null.toString()
var choice2: Int = 0
var email_adress: String = null.toString()
var information: String = null.toString()
var filename :String = "File.txt"
var content:String = null.toString()

fun show_options() // Visar alternativ
{
    println("1. Change name" +
            "2. Change surname" +
            "3. Change phonenumber" +
            "4. Change email")
}
fun meny() //Skapar meny
{
    println("1. Add contact" +
            "2. Remove contact" +
            "3. Change information of contact" +
            "4. Show Contacts" +
            "5. Show in alphabetical order" +
            "6. Save contacts to file" +
            "7. Read contacts from file")
}

fun show_contacts() // Skapar en funktion som printar informationlist som innehåller all information om personer
{
    for (elements in informationlist){
        println(" Firstname:" + elements.Firstname + " " +
                " Lastname:" + elements.Surname + " " +
                "phone-number: " + elements.Phonenumber + " " +
                " Email:" + elements.Email)
    }
}

fun add_contact() // Lägger till kontakt till informationlist
{
    println("Please write name, lastname, phone-number and email on individual lines to add a person. Iff suceded, skapad kontakt wil be displayed ")
    informationlist.add(Person(Firstname, Surname, Phonenumber, Email))
}

fun remove_contact() // Tar bort en kontakt i listan genom att jämföra emailar och ta bort i fall den finns.
{
    println("Please write the email adress of the person that you arte trying to remove")
    email_adress = readln()
    for (number: Int in 0..informationlist.count()-1)
    {
        if (email_adress == informationlist[number].Email)
        {
            informationlist.removeAt(number)
        }
    }
}

fun Show_in_alphabetical_order() //Visar listan i alfabetisk ordning via förnamn
{
    val sortedList = informationlist.sortedWith(compareBy({ it.Firstname }))
        for (elements in sortedList)
        {
            println(" Firstname: " + elements.Firstname +
                    " Lastname: " + elements.Surname + " " +
                    "phone-number: " + elements.Phonenumber +
                    " Email: " + elements.Email)
        }

}

fun Change_information_of_contact() // Ändrar information av en kontakt i listan informationlist
{

    println("Please write the email of the adress that you want to change!")
    email_adress = readln()
    for (number: Int in 0..informationlist.count()-1)
    {
        if (email_adress == informationlist[number].Email)
        {
            println("the email is in the list and the information can be changed. What do you want to change?")
            show_options()

            fun change_firstname()
            {
                println("Please write a new firstname")
                information = readln()
                informationlist[number].Firstname = information
            }

            fun change_Surname()
            {
                println("Please write a new surname")
                information = readln()
                informationlist[number].Surname = information
            }

            fun change_phonenumber(){
                println("Please write a new phonenumber")
                information = readln()
                informationlist[number].Phonenumber = information
            }

            fun change_email(){
                println("Please write a new email adress")
                information = readln()
                informationlist[number].Email = information
            }


            choice2 = readln().toInt()
            when(choice2){
                1 -> change_firstname()
                2 -> change_Surname()
                3 -> change_phonenumber()
                4 -> change_email()
            }
        }



        else{
            println("The email does not match any emails in the list")
        }

    }
}

fun Read_from_file() //Läser från fil
{
    val bufferedReader: BufferedReader = File("File.txt").bufferedReader()
    content = bufferedReader.use { it.readText() }
    println(content)
}

fun Write_to_file() // Skriver till fil
{
    File(filename).bufferedWriter().use { out ->
        for (number: Int in 0..informationlist.count()-1)
        {
            out.write(informationlist[number].Firstname + " ")
            out.write(informationlist[number].Surname + " ")
            out.write(informationlist[number].Phonenumber + " ")
            out.write(informationlist[number].Email + "\n")
        }
    }
}

fun choose_option() // En metod som visar vilka metoder som aktiveras beroende på vilken knapp man trycker på.
{
    when(choice.toInt())
    {
        1 -> add_contact()
        2 -> remove_contact()
        3 -> Change_information_of_contact()
        4 -> show_contacts()
        5 -> Show_in_alphabetical_order()
        6 -> Write_to_file()
        7 -> Read_from_file()
        else -> {
            println("please choose a number between 1 and 7")
        }
    }
}
fun main(args: Array<String>)
{
    while (choice != 8.toString()){
        meny()
        choice = readln()
        choose_option()
    }
}