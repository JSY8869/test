package com.ussu.memorydiary.API

import retrofit2.Call
import retrofit2.http.*

interface API {

//    @GET("/diary/Read")
//    fun getDiaryText(@Body dataClass: textDataClass): Call<textDataClass>

    //일기 저장
    @POST("/diary/Create")
    fun saveDiaryText(
        @Body dataClass: textInfo
    ): Call<textInfo>

    //일기 수정
    @FormUrlEncoded
    @PATCH("/diary/Update/{memberId}")
    fun editDiaryText(
        @Path("memberId") member_id: String,
        @Body dataClass: textInfo
    ): Call<textInfo>

    //일기 삭제
    @DELETE("/diary/Delete/{memberId}")
    fun deleteDiaryText(
        @Path("memberId") member_id: String
    ): Call<textInfo>

    //회원가입
    @POST("/login/Create")
    fun saveMemberInfo(
        @Body dataClass: memberInfo
    ): Call<memberInfo>

    //질문, 정답 가져오기
    @GET()
    fun getAnswer(
        @Path("memberId") member_id: String
    ): Call<questionInfo>

}