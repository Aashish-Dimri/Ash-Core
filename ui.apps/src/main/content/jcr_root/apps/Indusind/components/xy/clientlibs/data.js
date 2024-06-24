$.ajax({
    type : "GET",
    url : '/bin/custom/path',
    /*data : {
        pass your request parameter here, currently we are not passing any data
    },*/
    success : function(data, textStatus, jqXHR) {
        //write your logic that you need to perform on sucess
                },
    error : function(XMLHttpRequest, textStatus, errorThrown) {
        //write your logic that you need to perform on error
    }
});