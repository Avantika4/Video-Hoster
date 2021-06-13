function go()
{
    const uid=sessionStorage.getItem("userid");

    if(uid==undefined)
    {
        alert("Please login to create post")
        window.location=("./roulogin.html");
    }
    else{
        window.location=("./upload.html");
    }
}
function logsing()
{
    window.location=("./roulogin.html");
}
function logout()
{
    alert("You are logged out!")
    sessionStorage.removeItem("userid");
    document.getElementById("sin_sout").style.display="block";
    document.getElementById("logout").style.display="none";
}



function getall()
{

    const uid=sessionStorage.getItem("userid");

    if(uid==undefined)
    {
        document.getElementById("sin_sout").style.display="block";
        document.getElementById("logout").style.display="none";
    }
    else{
        document.getElementById("sin_sout").style.display="none";
        document.getElementById("logout").style.display="block"
    }

    var parent=document.getElementById("result");

    var xhttp = new XMLHttpRequest();
      xhttp.open("GET", "http://localhost:8080/getallpost", true);
     xhttp.onreadystatechange = function() {
         if (this.readyState == 4 && this.status == 200) {
             let list=JSON.parse(this.responseText);
             
             for(var i=0;i<list.length;i++)
             {
                
                 parent.appendChild(adddata(list[i]))
             }
 
         }
     };
     xhttp.send();
}

function adddata(data)
{
    //
    var main=document.createElement("Div");
    main.setAttribute("id","result_video");

    var title=document.createElement("h3");
    var title_text=document.createTextNode(data.postTitle);
    title.appendChild(title_text)
    main.appendChild(title)

    var creater=document.createElement("p");
    var creater_text=document.createTextNode("Created by: "+data.user);
    creater.appendChild(creater_text)
    main.appendChild(creater)

    var postid=document.createElement("p");
    var post_id_text=document.createTextNode("Postid: "+data.postId);
    postid.appendChild(post_id_text)
    main.appendChild(postid)


    var x = document.createElement("VIDEO");
    var src="http://localhost:8080/video/"+data.videopost;
    x.setAttribute("src",src);
	x.setAttribute("width", "400");
    x.setAttribute("height", "340");
    x.setAttribute("controls", "controls");
    main.appendChild(x)

    var desc=document.createElement("h3");
    var desc_text=document.createTextNode(data.postdesc);
    desc.appendChild(desc_text)
    main.appendChild(desc)

    return main;
}