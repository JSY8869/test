package com.ussu.memorydiary.API

//일기 저장, 수정, 삭제
data class textInfo(
    var member_id: String,
    var created_at: String,
    var text: String
)

//회원가입, 로그인
data class memberInfo(
    var member_id: String,
    var member_password: String,
    var score: Int
)

//질문, 답
data class questionInfo(
    var member_id: String,
    var created_at: String,
    var question: String,
    var answer: String
)
