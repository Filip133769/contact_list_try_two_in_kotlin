import java.io.File
import java.io.PrintWriter
import java.io.BufferedReader
val informationlist = ArrayList<Person>()
var name: String = null.toString()
var Lastname: String = null.toString()
var phonenumber: String = null.toString()
var email: String = null.toString()
var choice: String = null.toString()
var choice2: String = null.toString()
var email_adress: String = null.toString()
var new_surname: String = null.toString()
var new_phonenumber: String = null.toString()
var new_email_adress: String = null.toString()
var filename = "file.txt"
var myfile = File(filename)
var content:String = null.toString()

fun printlist(){
    for (elements in informationlist){
        println(" Firstname:" + elements.firstname +
                " Lastname:" + elements.surname + " " +
                "phone-number" + elements.phonenumber +
                " Email:" + elements.email)
    }
}
fun meny()
{
    println("1. Add contact" +
            "2. Remove contact" +
            "3. Change contact" +
            "4. Show Contacts" +
            "5. Show in alphabetical order" +
            "6. Save contacts to file" +
            "7. Read contacts from file")
}

fun show_contacts()
{
    printlist()
}

fun add_contact()
{
    println("Please write name, lastname, phone-number and email on individual lines to add a person. Iff succedded, skapad kontakt wil1 be displayed ")
    informationlist.add(Person(name, Lastname, phonenumber, email))
}

fun remove_contact()
{
    println("Please write the email adress of the person that you arte trying to remove")
    email_adress = readln()
    for (number: Int in 0..informationlist.count()-1)
    {
        if (email_adress == informationlist[number].email)
        {
            informationlist.removeAt(number)
        }
    }
}

fun Show_in_alphabetical_order()
{
    val sortedList = informationlist.sortedWith(compareBy({ it.firstname }))
    for (elements in sortedList)
    {
        printlist()
    }
}

fun Change_information_of_contact()
{
    println("Please write the email of the adress that you want to change!")
    email_adress = readln()
    for (number: Int in 0..informationlist.count()-1)
    {
        if (email_adress == informationlist[number].email)
        {
            println("the email is in the list and the information can be changed. What do you want to change?")
        }
        println("1. Change name" +
                "2. Change surname" +
                "3. Change phonenumber" +
                "4. Change email")

        fun change_name()
        {
            new_email_adress = readln()
            informationlist[number].email = new_email_adress
        }

        fun change_Surname()
        {
            new_surname = readln()
            informationlist[number].surname= new_surname
        }

        fun change_phonenumber()
        {
            new_phonenumber = readln()
            informationlist[number].phonenumber = new_phonenumber
        }

        fun change_email()
        {
            new_email_adress = readln()
            informationlist[number].email = new_email_adress
        }

        when(choice2.toInt())
        {
            1 -> change_name()
            2 -> change_Surname()
            3 -> change_phonenumber()
            4 -> change_email()
        }
    }
}

fun Read_from_file()
{
    val bufferedReader: BufferedReader = File("file.txt").bufferedReader()
    content = bufferedReader.use { it.readText() }
    println(content)
}

fun Write_to_file()
{
    File(filename).bufferedWriter()
    File(filename).bufferedWriter().use { out ->
        for (number: Int in 0..informationlist.count()-1)
        {
            out.write(informationlist[number].firstname + "\b")
            out.write(informationlist[number].surname + "\b")
            out.write(informationlist[number].phonenumber + "\b")
            out.write(informationlist[number].email + "\n")
        }
    }

}


fun choose_option()
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
    while (choice != 8.toString())
    {
        meny()
        choice = readln()
        choose_option()
    }
}
