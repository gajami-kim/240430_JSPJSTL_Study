console.log(bnoVal);

document.getElementById('cmtAddBtn').addEventListener('click',()=>{
    let cmtText = document.getElementById('cmtText').value;
    const cmtWriter = document.getElementById('cmtWriter').value;
    if(cmtText==null||cmtText=='') {
        alert("댓글을 입력해주세요");
        return false;
    } else {
        let cmtData = {
            bno : bnoVal,
            writer : cmtWriter,
            content : cmtText
        };

        postCommentToServer(cmtData).then(result=>{
            // console.log(result);
            if(result==='1') {
                alert("댓글등록 성공");
                document.getElementById('cmtText').value='';
            }
            // printCommentList(bnoVal);
        })
    }
});

async function postCommentToServer(cmtData) {
    try {
        const url = "/cmt/post";
        const config = {
            method:'post',
            headers:{
                'content-type' : 'application/json; charset=utf-8'
            },
            body:JSON.stringify(cmtData)
        };

        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

function spreadCommentList(result) {
    console.log(result);
    let div = document.getElementById('commentLine');
    div.innerHTML='';
    for(let i=0; i<result.length; i++){
        let html = `<div>`;
        html+=`<div>comment Line></div>`;
        html+=`<div>${result[i].cno} / ${result[i].writer} / ${result[i].regdate}</div>`;
        html+=`<div>`;
        html+=`<input type="text" value="content" placeholder="Add Comment..">`;
        html+=`<button type="button" class="cmtModBtn">수정</button>`;
        html+=`<button type="button" class="cmtDelBtn">삭제</button>`;
        html+=`</div></div><hr>`;
        div.innerHTML = html;
    }
}

async function getCommentListFromServer(bno){
    try {
        const resp = await fetch("/cmt/list?bno="+bno);
        const result = await resp.json(); //'[{댓1},{댓2},{댓3}]'
        return result;
    } catch (error) {
        console.log(error);
    }
}

function printCommentList(bno){
    getCommentListFromServer(bno).then(result=>{
        console.log(result);
        if(result.length>0) {
            spreadCommentList(result);
        } else {
            let div = document.getElementById('commentLine');
            div.innerHTML = `<div>comment가 없습니다.</div>`;
        }
    })
}