/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function queryUser()
{
    //alert("yes");
    var option = document.getElementById("selection");
    var user = option.options[option.selectedIndex].value;
    queryBug(user);
}
        
function queryBug(user)
{
    //alert(user)
    //var ele=document.getElementById("stdSearch").value;
    var xmlhttp;
    var strAjUrlData="http://10.136.4.62/bugBasket/BugBasket?user="+user;
    //var strAjUrlData="http://10.136.131.140/bugBasket/BugBasket?user="+user;
    //alert(strAjUrlData)
      
    if (window.XMLHttpRequest)
    {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    }
    else
    {
        // code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            document.getElementById("httpResponse").innerHTML=xmlhttp.responseText;
        }
        else
        {
            alet(xmlhttp.status);
        }
    }
            
    xmlhttp.open("GET",strAjUrlData,true);
    xmlhttp.send();
}


