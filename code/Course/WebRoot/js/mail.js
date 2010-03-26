function checkCheckBox(form,objtag)
	{
		if (typeof(objtag.checked) == "undefined")
		{
			objtag.checked = true;
		}
		for(var i = 0; i < form.elements.length; i++) 
		{
			var e = form.elements[i];
			if(e.name == "pmitemid") 
			{
				e.checked = objtag.checked;
			}
		}
		objtag.checked = !objtag.checked;
	}

function callBack(data) {

	row1.id = currpmdiv;
	row1.className = 'row';
	var cell1 = row1.insertCell(0);
	cell1.innerHTML = '&nbsp;';
	cell1.className = 'altbg1';
	cell1.colSpan = '2';
	var cell2 = row1.insertCell(1);
	cell2.colSpan = '3';
	cell2.innerHTML = data;
	cell2.className = 'altbg1';

}

function changestatus(obj) {
	if (obj.innerHTML.substr(0, 3).toLowerCase() == '<b>') {
		obj.innerHTML = obj.innerHTML.substr(3, obj.innerHTML.length - 7);
		if (folder == 'inbox' && obj.href.indexOf('folder=announce') == -1)
			$('pm_unread').innerHTML = parseInt($('pm_unread').innerHTML) - 1;
	}
}
function doane(event) {
	e = event ? event : window.event;
	if (is_ie) {
		e.returnValue = false;
		e.cancelBubble = true;
	} else {
		e.stopPropagation();
		e.preventDefault();
	}
}