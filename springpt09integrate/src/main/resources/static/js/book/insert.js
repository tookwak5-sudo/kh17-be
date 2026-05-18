//도서 등록화면 검사 코드

$(function(){
        //상태객체
       var state = {
           bookTitleValid : false,
           bookAuthorValid : true, //선택항목(true)
           bookPublisherValid : true,
           bookPublicationDateValid : true,
           bookPriceValid : false,
           bookPageCountValid : false,
           bookGenreValid : false,

           ok : function() {
               return Object.values(this)//이 객체의 모든 이름에 대한 값을 반환해라
               .filter(v => typeof v == "boolean") // boolean값만 추출해서
               .every(v => v === true); //모두 true인지 확인해서 반환해라;
           }
       };

       //개별 입력창
       $("[name=bookTitle]").on("blur", function(){
           var valid = $(this).val().length > 0;
           $(this).removeClass("success fail").addClass(valid ? "success" : "fail");
           state.bookTitleValid = valid;
       });

       $("[name=bookAuthor]").on("blur", function(){
           var regex = /^[^!@#$]+$/;
           var valid = $(this).val().length == 0 || regex.test($(this).val());
           $(this).removeClass("success fail").addClass(valid ? "success" : "fail");
           state.bookAuthorValid = valid;
       });

       $("[name=bookPublisher]").on("blur", function(){
           $(this).addClass("success");
           state.bookPublisherValid = true;
       });

       $("[name=bookPublicationDate]").on("blur", function(){
           var regex = /^([0-9]{4})-(((02)-(0[1-9]|1[0-9]|2[0-9]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01])))$/;
           // var valid = regex.test(this.value);
           var valid = regex.test($(this).val());
           $(this).removeClass("success fail").addClass(valid ? "success" : "fail");
           bookPublicationDateValid = valid;
       });

       $("[name=bookPrice]").on("blur", function(){
           var price = parseInt($(this).val());
           // 상한선이 없으면 숫자가 커질 시 e-22와 같은 방식으로 표현이 되기 때문에 상한선 표기
           var valid = price >= 0 && price <= 1000000000; 
           $(this).removeClass("success fail").addClass(valid ? "success" : "fail");
           bookPriceValid = valid;
       });

       $("[name=bookPageCount]").on("blur", function(){
           var pages = parseInt($(this).val());
           var valid = pages >= 0;
           $(this).removeClass("success fail").addClass(valid ? "success" : "fail");
           bookPageCountValid = valid;
       });

       $("[name=bookGenre]").on("input", function(){
           var regex = /^(판타지|교양|소설|역사|과학|추리소설|자기계발|수험서)$/;
           var valid = regex.test($(this).val());
           $(this).removeClass("success fail").addClass(valid ? "success" : "fail");
           bookGenreValid = valid;
       });

       //숫자처리
        $("[inputmode=numeric]").on("input", function(){
           var originValue = $(this).val(); //숫자지만 실제로는 문자열로 처리를 하고 있기 때문에
           var replaceValue = originValue.replace(/[^0-9]/g, ""); //replace에 g를 붙인 것과 = replaceAll이 동일          
           $(this).val(parseInt(replaceValue || 0));
        });

       //폼 검사
        $(".form-check").on("submit", function(){
           //화면처리(이벤트 트리거)
           $(this).find("select[name]").trigger("input"); 
           $("input[name], textarea[name]").trigger("blur");

           return state.ok(); //stat.ok() 상태에 따라 전송해!
        });
   });