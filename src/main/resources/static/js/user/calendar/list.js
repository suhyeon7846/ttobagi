//import ModalBox from "./ModalBox.js";

class CSS{
    static set(element, styles){

        for(let key in styles)
            element.style[key] = styles[key];
    }
}

class ModalBox{
    
    // 1. 객체를 모두 직접 생성했을 때의 장점/단점
    // createElement/appendChild
    // 2. 객체를 모두 문자열로 생성했을 때의
    // innertHTML
    // 3. 객체 생성과 문자열을 조합
    // outer Element만 생성 -> inner는 html로   
    static alert(message=""){
        
        
        return new Promise(resolve=>{
            
            let screen = document.createElement("div");
            let frame = document.createElement("div");
            // 차트, 탐색기, 드래그 업로드 박스, 모달박스, 편집기, ...
            CSS.set(screen, {
                position:"fixed",
                left:"0px",
                top:"0px",
                width:"100%",
                height:"100%",
                background:"#000",
                opacity:"0",
                transition:"opacity 1s",
				zIndex:"9"
            });
            document.body.append(screen);

            setTimeout(()=>{
                CSS.set(screen,{
                    opacity:"0.5"
                })
            });

            screen.addEventListener("transitionend", ()=>{
                CSS.set(frame, {
                    opacity:"1",
                    top:"50%"
                });
            });

            
            CSS.set(frame, {
                position:"fixed",
                top: "50%",
                left:"50%",
				transform: "translate(-50%,-50%)",
                background: "#fff",
                width:"500px",
                minHeight: "150px",
                display: "flex",
                flexDirection: "column",
                opacity:"0",
                transition:"top 1s",
				zIndex:"10"
            });
            
            frame.innerHTML = `
            <div>
            일정등록
            </div>
            <div style="flex-grow: 1; display:flex;justify-content: center;align-items: center;">
            ${message}
            </div>
            <div style="display:flex;justify-content: center; border-top: 1px solid #e9e9e9;">
            <input type="button" value="OK">
            <input type="button" value="CANCEL">
            </div>
            `;

            document.body.append(frame);

            const okButton = frame.querySelector("input[value=OK]");
            const cancelButton = frame.querySelector("input[value=CANCEL]");
            okButton.onclick = ()=>{
                resolve("OK");
                screen.remove();
                frame.remove();
            };
            cancelButton.onclick = ()=>{
                resolve("CANCEL");
                screen.remove();
                frame.remove();
            };


        });
    }
    static confirm(){
        
    }    
}

  document.addEventListener('DOMContentLoaded', function() {
    var srcCalendarEl = document.getElementById('source-calendar');

    var srcCalendar = new FullCalendar.Calendar(srcCalendarEl, {
      plugins: [ 'interaction', 'dayGrid' ],
      editable: true,
      defaultDate: new Date(),
      events: [
        {
          title: 'event1',
          start: '2021-01-11',
          end: '2021-01-12T16:00:00'
        },
        {
          title: 'event2',
          start: '2021-01-25T10:00:00',
          end: '2021-02-20T16:00:00'
        }
      ],
      eventLeave: function(info) { 
        console.log('event left!', info.event);
      }
    });

    srcCalendar.render();
	
	
	const dayGrid = document.querySelector(".fc-day-grid");
	
	console.log(111);
	dayGrid.addEventListener("click",(e)=>{
		console.log(srcCalendar.__proto__);
	});
	

  });