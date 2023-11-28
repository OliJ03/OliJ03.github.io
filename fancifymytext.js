function onAlert(){
     document.getElementById("text").style.fontSize = "24px";

}
window.onload = selectText();
function selectText() {
    
        var fancyButton = document.getElementById("fancy");
        var boringButton = document.getElementById("boring");

        fancyButton.addEventListener("change", function() {
            if(fancyButton.checked) {
                document.getElementById("text").style.fontWeight = "bold";
                document.getElementById("text").style.color = "blue";
                document.getElementById("text").style.textDecoration = "underline";
            }
        boringButton.addEventListener("change", function() {
            if(boringButton.checked){
                document.getElementById("text").style.fontWeight = "initial"
                document.getElementById("text").style.color = "black";
                document.getElementById("text").style.textDecoration = "";
            }
        })
        });
    }


function onUpperCaseAndMoo() { 
    var inputValue = document.getElementById("text").value;
    var sentences = inputValue.split('.');

    for (var i = 0; i < sentences.length; i++) {
        sentences[i] = sentences[i].toUpperCase().trim();

        if (i < sentences.length - 1) {
            sentences[i] += ". -Moo";
        }
    }

    var modifiedText = sentences.join("");
    document.getElementById("text").value = modifiedText;
}
