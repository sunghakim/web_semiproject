'use strict';

const pwconfirm = document.querySelector('#error');

const pass = document.querySelector('.pass_ipt');
const passCon = document.querySelector('.pass_confirm');


passCon.addEventListener('blur', ()=>{
if(pass.value !== passCon.value){
        pwconfirm.innerHTML = "비밀번호가 일치하지 않습니다.";
        pwconfirm.style.display = "block";
    } else{
        pwconfirm.style.display = "none";
    }
});

