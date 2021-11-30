'use strict';
const checkboxes = document.querySelectorAll('input[type="checkbox"]');
const clearAlll = document.querySelectorAll('#memberlist-clearall');
const addboardBtn = document.querySelector('#addboard_btn');

function selectAll(selectAll){
    checkboxes.forEach((checkbox)=>{
        checkbox.checked = selectAll.checked;
    })

}

function deleteall(){
    if(confirm("선택된 게시판을 삭제하시겠습니까?")==true){
        document.form.submit();
    }else{
        return;
    }

}

function deleteallMember(){
    if(confirm("선택된 회원을 삭제하시겠습니까?")==true){
        document.form.submit();
    }else{
        return;
    }

}
