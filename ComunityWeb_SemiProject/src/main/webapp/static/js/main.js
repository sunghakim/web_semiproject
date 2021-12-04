'use strict';
const checkboxes = document.querySelectorAll('input[type="checkbox"]');
const clearAlll = document.querySelectorAll('#memberlist-clearall');
const noticeTitle = document.querySelector('#notice_title');
const noticeContent = document.querySelector('#notice_textarea');
const boardTitle = document.querySelector('#board_name');

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

function noticeAdd(){
    if(noticeTitle.value===''){
        alert('제목을 입력하세요.');
        console.log("ehlsi");
        return;
    } else if(noticeContent.value===''){
        alert('내용을 입력하세요');
        return;
    } else{
        if(confirm("등록하시겠습니까?")==true){
            document.form.submit();
        }else{
            return;
        }
    }
}

function boardAdd(){
    if(boardTitle.value===''){
        alert('게시판 이름을 입력하세요.');
        return;
    } else{
        if(confirm("등록하시겠습니까?")==true){
            document.form.submit();
        }else{
            return;
        }
    }
}
function quiteCommunity(){
    if(confirm("선택된 게시판을 삭제하시겠습니까?")==true){
        document.form.submit();
    }else{
        return;
    }

}

function updateBoard(){
   let new_board =  prompt("변경할 게시판 이름을 입력하세요.");
   alert("변경된 이름 : " + new_board);
}