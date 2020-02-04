<template>
    <div class="wrap">
        <div class="login-wrap">
            <div class="enter" id="enter">
                <h1>회원가입</h1>
                <div class="join-form" id="" style="">
                    <h5>회원정보 입력</h5>
                    <div class="join-infor-text">
                        * 필수 입력 사항
                    </div>
                    <dl>
                        <dt><em class="must">* </em>아이디(이메일)</dt>
                        <dd>
                            <input class="input-large" type="email" id="memberId" name="memberId" value="" placeholder="아이디(이메일) 입력">
                        </dd>
                    </dl>
                    <dl>
                        <dt><em class="must">* </em>비밀번호</dt>
                        <dd>
                            <input class="input-large" type="password" id="password" name="password" placeholder="영문/숫자/특수문자 조합하여 8~20자 입력" maxlength="20">
                        </dd>
                    </dl>
                    <dl>
                        <dt><em class="must">* </em>비밀번호  확인</dt>
                        <dd>
                            <input class="input-large" type="password" id="password_re" name="password_re" placeholder="비밀번호 한 번 더 입력" maxlength="20">
                        </dd>
                    </dl>
                    <dl>
                        <dt><em class="must">* </em>이름</dt>
                        <dd>
                            <input class="input-large" type="text" id="username" name="username" value="" placeholder="이름 입력" maxlength="30">
                        </dd>
                    </dl>
                    <dl>
                        <dt><em class="must">* </em>휴대전화</dt>
                        <dd>
                            <input class="input-large" type="text" id="mobileNo" name="mobileNo" placeholder="___-____-____" maxlength="13" >
                        </dd>
                    </dl>
                </div>
                <button @click="join">Join</button>
            </div>
        </div>
    </div>
</template>

<script>
    import axios from 'axios'
    export default {
        name: "join",
        methods: {
            join () {
                var data = new FormData();
                axios.post('/users', data)
                    .then(res => {
                        // eslint-disable-next-line no-console
                        console.log(res);
                    })

            }
        },
    }

</script>

<style scoped>

</style>