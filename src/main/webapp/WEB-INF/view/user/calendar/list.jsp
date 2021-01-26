<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<link href='/user/calendar/packages/core/main.css' rel='stylesheet' />
<link href='/user/calendar/packages/daygrid/main.css' rel='stylesheet' />
<script src='/user/calendar/packages/core/main.js'></script>
<script src='/user/calendar/packages/interaction/main.js'></script>
<script src='/user/calendar/packages/daygrid/main.js'></script>
<script>

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
  });
</script>
<style>

  body {
    font-size: 14px;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
  }
  

  #source-calendar{
    width: 800px;
    margin: 0 auto;
    
  }

</style>
</head>
<body>
	<div >
	
		<div id='source-calendar'></div>
	</div>

</body>
</html>
