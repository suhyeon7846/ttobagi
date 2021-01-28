//import ModalBox from "./ModalBox.js";

class CSS{
    static set(element, styles){

        for(let key in styles)
            element.style[key] = styles[key];
    }
}

function getFormatDate(date){
    var year = date.getFullYear();              //yyyy
    var month = (1 + date.getMonth());          //M
    month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
    var day = date.getDate();                   //d
    day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
    return  year + '-' + month + '-' + day;       //'-' 추가하여 yyyy-mm-dd 형태 생성 가능
}

class ModalBox{
  
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
            <div class="schedule">
				시작 : <input name="startDate" type="date"/> <input name="startTime" type="time"/><br>
				종료 : <input name="endDate" type="date"/> <input name="endTime" type="time"/><br>
				장소 : <input style="width:230px;" name="location" type="text" placeholder="장소" /><br>
				제목 : <input style="width:230px;" name="title" type="text" placeholder="일정내용" /><br>
				상세내용<br><textarea style="width:263px; height:300px;" name="content"></textarea>
				
			</div>
            </div>
            <div style="display:flex;justify-content: center; border-top: 1px solid #e9e9e9;">
            <input type="button" value="OK">
            <input type="button" value="CANCEL">
            </div>
            `;

            document.body.append(frame);

            const okButton = frame.querySelector("input[value=OK]");
            const cancelButton = frame.querySelector("input[value=CANCEL]");
			const startDate = frame.querySelector("input[name=startDate]");
			const startTime = frame.querySelector("input[name=startTime]");
			const endDate = frame.querySelector("input[name=endDate]");
			const endTime = frame.querySelector("input[name=endTime]");
			const title = frame.querySelector("input[name=title]");
			const content = frame.querySelector("textarea[name=content]");
			const location = frame.querySelector("input[name=location]");
            okButton.onclick = ()=>{
				let schedule = {
					start:startDate.value+"T"+startTime.value,
					end:endDate.value+"T"+endTime.value,
					title:title.value,
					content:content.value,
					location:location.value
				}
                resolve(schedule);
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

class DetailBox{
  
    static detail(event){
        
        
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
            일정
            </div>
            <div style="flex-grow: 1; display:flex;justify-content: center;align-items: center;">
            <div class="schedule">
				시작 : <input name="startDate" type="date" value="${getFormatDate(event.start)}"/> <input name="startTime" type="time"/><br>
				종료 : <input name="endDate" type="date" value="${getFormatDate(event.end)}"/> <input name="endTime" type="time"/><br>
				장소 : <input style="width:230px;" name="location" type="text" placeholder="장소" /><br>
				제목 : <input style="width:230px;" name="title" type="text" placeholder="일정내용" /><br>
				상세내용<br><textarea style="width:263px; height:300px;" name="content"></textarea>
				
			</div>
            </div>
            <div style="display:flex;justify-content: center; border-top: 1px solid #e9e9e9;">
            <input type="button" value="OK">
            <input type="button" value="CANCEL">
            </div>
            `;

            document.body.append(frame);

            const okButton = frame.querySelector("input[value=OK]");
            const cancelButton = frame.querySelector("input[value=CANCEL]");
			const startDate = frame.querySelector("input[name=startDate]");
			const startTime = frame.querySelector("input[name=startTime]");
			const endDate = frame.querySelector("input[name=endDate]");
			const endTime = frame.querySelector("input[name=endTime]");
			const title = frame.querySelector("input[name=title]");
			const content = frame.querySelector("textarea[name=content]");
			const location = frame.querySelector("input[name=location]");
            okButton.onclick = ()=>{
				let schedule = {
					start:startDate.value+"T"+startTime.value,
					end:endDate.value+"T"+endTime.value,
					title:title.value,
					content:content.value,
					location:location.value
				}
                resolve(schedule);
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
          end: '2021-01-12T16:00:00',
		  location:"seoul",
		  id:1
        },
        {
          title: 'event2',
          start: '2021-01-25T10:00',
          end: '2021-02-20T16:00'
        }
      ],
      eventLeave: function(info) { 
        console.log('event left!', info.event);
      }
    });

    srcCalendar.render();
	
	
	const dayGrid = document.querySelector(".fc-day-grid");
	
	

	dayGrid.addEventListener("click",(e)=>{
		//console.log(e.target.getAttribute("class")=="fc-content");
		if(!e.target.classList.contains("fc-content") && 
		!e.target.classList.contains("fc-time") &&
		!e.target.classList.contains("fc-title") ){
			
			ModalBox.alert().then(schedule=>{
				srcCalendar.addEvent({
		          title: schedule.title,
		          start: schedule.start,
		          end: schedule.end,
				  location:schedule.location
		        })
			});
		}
		else if(e.target.classList.contains("fc-content")){
			for(var event of srcCalendar.getEvents()){
				if(event.id == e.target.querySelector("input[type=hidden]").value){
					DetailBox.detail(event);
				}
			}
		}
		else if(!e.target.classList.contains("fc-content")){
			for(var event of srcCalendar.getEvents()){
				if(event.id == e.target.parentNode.querySelector("input[type=hidden]").value){
					DetailBox.detail(event);
				}
			}
		}
	});
	

  });