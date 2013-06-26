package model

import scala.slick.driver.H2Driver.simple._

object IssueComments extends Table[IssueComment]("ISSUE_COMMENT") with Functions {
  def userName = column[String]("USER_NAME")
  def repositoryName = column[String]("REPOSITORY_NAME")
  def issueId = column[Int]("ISSUE_ID")
  def commentId = column[Int]("COMMENT_ID", O PrimaryKey, O AutoInc)
  def commentedUserName = column[String]("COMMENTED_USER_NAME")
  def content = column[String]("CONTENT")
  def registeredDate = column[java.util.Date]("REGISTERED_DATE")
  def updatedDate = column[java.util.Date]("UPDATED_DATE")
  def * = userName ~ repositoryName ~ issueId ~ commentId ~ commentedUserName ~ content ~ registeredDate ~ updatedDate <> (IssueComment, IssueComment.unapply _)

  def autoInc = userName ~ repositoryName ~ issueId ~ commentedUserName ~ content ~ registeredDate ~ updatedDate returning commentId
}

case class IssueComment(
    userName: String,
    repositoryName: String,
    issueId: Int,
    commentId: Int,
    commentedUserName: String,
    content: String,
    registeredDate: java.util.Date,
    updatedDate: java.util.Date
)