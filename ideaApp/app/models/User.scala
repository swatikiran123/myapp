package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

case class User(
email:String,
password: String
confirmpassword:String
firstName:String
lastName:String
phonenumber:String
)


object User {

	val parser: RowParser[User] = {
		get[String]("DataUse.email") ~ 
		get[String]("DataUse.password") ~ 
		get[String]("DataUse.confirmpassword") ~ 
		get[String]("DataUse.firstName") ~
		get[String]("DataUse.lastName") ~
		get[String]("DataUse.phonenumber") map {
	    	case email ~ password ~ confirmpassword ~ firstName ~ lastName ~ phonenumber
	    		=> User(email,password,confirmpassword,firstName,lastName,phonenumber)
	    	}
	}
  
    def findAll: List[User] = {
        DB.withConnection { implicit connection =>
            SQL("SELECT * FROM DataUse").as(parser *)
        }
    }

   
}