
$(document).ready(function() {
    $('.delete-guitar').on('click', function (){
        /*<![CDATA[*/
        var path = /*[[@{/}]]*/'remove';
        /*]]>*/

        var id=$(this).attr('id');

        bootbox.confirm({
            message: "Are you sure to remove this guitar? It can't be undone.",
            buttons: {
                cancel: {
                    label:'<i class="fa fa-times"></i> Cancel'
                },
                confirm: {
                    label:'<i class="fa fa-check"></i> Confirm'
                }
            },
            callback: function(confirmed) {
                if(confirmed) {
                    $.post(path, {'id':id}, function(res) {
                        location.reload();
                    });
                }
            }
        });
    });





    $('#deleteSelected').click(function() {
        var idList= $('.checkboxGuitar');
        var guitarIdList=[];
        for (var i = 0; i < idList.length; i++) {
            if(idList[i].checked==true) {
                guitarIdList.push(idList[i]['id'])
            }
        }

        console.log(guitarIdList);

        /*<![CDATA[*/
        var path = /*[[@{/}]]*/'removeList';
        /*]]>*/

        bootbox.confirm({
            message: "Are you sure to remove all selected guitars? It can't be undone.",
            buttons: {
                cancel: {
                    label:'<i class="fa fa-times"></i> Cancel'
                },
                confirm: {
                    label:'<i class="fa fa-check"></i> Confirm'
                }
            },
            callback: function(confirmed) {
                if(confirmed) {
                    $.ajax({
                        type: 'POST',
                        url: path,
                        data: JSON.stringify(guitarIdList),
                        contentType: "application/json",
                        success: function(res) {
                            console.log(res);
                            location.reload()
                        },
                        error: function(res){
                            console.log(res);
                            location.reload();
                        }
                    });
                }
            }
        });
    });

    $("#selectAllGuitars").click(function() {
        if($(this).prop("checked")==true) {
            $(".checkboxGuitar").prop("checked",true);
        } else if ($(this).prop("checked")==false) {
            $(".checkboxGuitar").prop("checked",false);
        }
    })
});