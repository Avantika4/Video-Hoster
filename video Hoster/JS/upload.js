var formClass=document.getElementById("videoform");
formClass.addEventListener('submit', upload);

function upload(event)
{
    alert("sending post...")
    var formData = new FormData();
    event.preventDefault();
    formData.append("file", document.getElementById("FileField").files[0]);

    let posttitle=document.getElementById("posttitle").value;
    let postdesc=document.getElementById("postdesc").value;

    let data={
            "postTitle":posttitle,
            "postdesc":postdesc      
    }
    formData.append("data", JSON.stringify(data));
     event.preventDefault();

     var id=sessionStorage.getItem("userid");
    console.log(id);
    var xhr=new XMLHttpRequest();
    var bb=formData.get("data")
    var enc = btoa(bb);
    
    xhr.open("POST", `http://localhost:8080/${id}/upload/${enc}`, true);
    xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {

            if(this.responseText=="Sorry")
            {
            alert("post can't be added")    
            }
            else{
            alert("post added");
            window.location=("./home.html");

            }

        }
        
    }


    xhr.send(formData);
}