package com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model

import com.google.gson.annotations.SerializedName
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.OTPVerification.userdata

data class MyDiary( @SerializedName("status")
                     val status: Boolean,
                     @SerializedName("msg")
                     val message: String,
                     @SerializedName("data")
                     val data:List<DiaryData>){

    data class DiaryData(@SerializedName("Event")
                         val Eventm: List<Event>,
                         @SerializedName("Connection")
                         val Connectionm: List<Connection>,
                         @SerializedName("Requirement")
                         val Requirementm: List<Requirement>,
                         @SerializedName("Lead")
                         val Leadm: List<Lead>,
                         @SerializedName("Buddies")
                         val Buddiesm: List<Buddies>,
                         @SerializedName("Post")
                         val Postm: List<Post>,
                         @SerializedName("Contribution")
                         val Contributionm: List<Contribution>,
                         @SerializedName("J4EMeets")
                         val J4EMeetsm: List<J4EMeets>,
                         @SerializedName("BusinessTransaction")
                         val BusinessTransactionm: List<BusinessTransaction>,
                         @SerializedName("Testinomial")
                         val Testinomialm: List<Testinomial>,
                         @SerializedName("Award")
                         val Awardm: List<Award>,
                         @SerializedName("Recognitions")
                         val Recognitionsm: List<Recognitions>,
                         @SerializedName("MembershipBenefits")
                         val MembershipBenefits: List<MembershipBenefitsm>,
                         @SerializedName("RecommendedTo")
                         val RecommendedTo: List<RecommendedTom>,
                         @SerializedName("RecommendedBy")
                         val RecommendedBy: List<RecommendedBym>,
                         @SerializedName("ReferralGiven")
                         val ReferralGiven:List<ReferralGivenm>,
                         @SerializedName("ReferralReceived")
                         val ReferralReceived:List<ReferralReceivedm>,
                         @SerializedName("ReportCard")
                         val ReportCard: List<ReportCardm>,
                         @SerializedName("GuestInvited")
                         val GuestInvitedm: List<GuestInvited>,
                         @SerializedName("PendingResponsibilities")
                         val PendingResponsibilitiesm: List<PendingResponsibilities>,
                         @SerializedName("notification_count")
                         val notification_count: CountBubbleData
    ) {
        data class PendingResponsibilities(
            @SerializedName("Leads")
            val Leads: String,
            @SerializedName("BuddyMeet")
            val BuddyMeet: String,
            @SerializedName("FollowUP")
            val FollowUP: String
        )


        data class GuestInvited(
            @SerializedName("Total")
            val Total: String
        )

        data class ReportCardm(
            @SerializedName("Total")
            val Total: String
        )

        data class RecommendedBym(
            @SerializedName("Peoples")
            val Peoples: String,
            @SerializedName("Times")
            val Times: String
        )

        data class RecommendedTom(
            @SerializedName("Peoples")
            val Peoples: String,
            @SerializedName("Times")
            val Times: String
        )

        data class ReferralGivenm(
            @SerializedName("Pending")
            val Pending: String,
            @SerializedName("Complete")
            val Complete: String
        )

        data class ReferralReceivedm(
            @SerializedName("Pending")
            val Pending: String,
            @SerializedName("Complete")
            val Complete: String
        )

        data class MembershipBenefitsm(
            @SerializedName("Received")
            val Received: String,
            @SerializedName("Saving")
            val Saving: String
        )

        data class J4EMeets(
            @SerializedName("Present")
            val Present: String,
            @SerializedName("Absent")
            val Absent: String
        )

        data class BusinessTransaction(
            @SerializedName("Received")
            val Received: String,
            @SerializedName("Given")
            val Given: String
        )

        data class Testinomial(
            @SerializedName("Received")
            val Received: String,
            @SerializedName("Given")
            val Given: String
        )

        data class Award(
            @SerializedName("Total")
            val Total: String
        )

        data class Recognitions(
            @SerializedName("Total")
            val Total: String
        )

        data class Event(
            @SerializedName("InterestedEvent")
            val InterestedEvent: String,
            @SerializedName("AttendedEvent")
            val AttendedEvent: String
        )

        data class Connection(
            @SerializedName("SentConnection")
            val SentConnection: String,
            @SerializedName("ReceiveConnection")
            val ReceiveConnection: String
        )

        data class Requirement(
            @SerializedName("Saved")
            val Saved: String,
            @SerializedName("Open")
            val Open: String
        )

        data class Lead(
            @SerializedName("Closed")
            val Closed: String,
            @SerializedName("Open")
            val Open: String
        )

        data class Buddies(
            @SerializedName("Total")
            val Total: String
        )

        data class Post(
            @SerializedName("Total")
            val Total: String
        )

        data class Contribution(
            @SerializedName("Conversions")
            val Conversions: String,
            @SerializedName("Revenue")
            val Revenue: String
        )


        data class CountBubbleData(
            @SerializedName("post_count")
            val post_count: String,
            @SerializedName("event_count")
            val event_count: String,
            @SerializedName("lead_count")
            val lead_count: String,
            @SerializedName("buddy_count")
            val buddy_count: String,
            @SerializedName("notificat_count")
            val notificat_count: String,
            @SerializedName("connection_sent_count")
            val connection_sent_count: String,
            @SerializedName("connection_receive_count")
            val connection_receive_count: String
        )
    }


}



