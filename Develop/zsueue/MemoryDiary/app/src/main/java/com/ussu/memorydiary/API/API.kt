package com.ussu.memorydiary.API

import retrofit2.Call
import retrofit2.http.*

/**
 * diary API, member API 나눠서 작성바람
 */
interface API {

//    @GET("/diary/Read")
//    fun getDiaryText(@Body dataClass: textDataClass): Call<textDataClass>

    //일기 저장
    @POST("/diary/Create")
    fun saveDiaryText(
        @Body dataClass: textInfo
    ): Call<textInfo>

    //일기 수정
    /**
     * 수정 요함 -> PATCH 에서 PUT,POST
     */
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

    //로그인 시 id, pw 가져오기
    @GET("/login/Read")
    fun readMemberInfo(
        @Query("memberId") member_id: String,
    ): Call<memberInfo>

    //질문, 정답 가져오기
    @GET()
    fun getAnswer(
        @Path("memberId") member_id: String
    ): Call<questionInfo>

}