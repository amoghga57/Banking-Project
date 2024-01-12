let count=0

let disp=()=>{
    if(count%2==0)
    {
        document.getElementById("disp").style="visibility:visible"
    }
    else
    {
        document.getElementById("disp").style="visibility:hidden"
    }
    count++
}

function deletAcc()
{
    document.getElementById("deleteBox").style="visibility:visible"
    document.getElementById("disp").style="visibility:hidden"
    document.getElementById('body').style="visibility:hidden;background-color:rgba(128, 128, 128, 0.60)"
    
}