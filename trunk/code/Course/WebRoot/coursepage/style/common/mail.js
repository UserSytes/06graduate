$( function() {
	var de = document.documentElement;
	var db = document.body;
	var viewW = de.clientWidth == 0 ? db.clientWidth : de.clientWidth;
	var viewH = de.clientHeight == 0 ? db.clientHeight : de.clientHeight;

	$("#blue").click( function() {
		$.post("changeColorAction.action", {
			color :'blue'
		}, callBack, "json");
	});
	$("#green").click( function() {
		$.post("changeColorAction.action", {
			color :'green'
		}, callBack, "json");
	});
	$("#orange").click( function() {
		$.post("changeColorAction.action", {
			color :'orange'
		}, callBack, "json");
	});
	$("#white").click( function() {
		$.post("changeColorAction.action", {
			color :'white'
		}, callBack, "json");
	});
	$("#red").click( function() {
		$.post("changeColorAction.action", {
			color :'red'
		}, callBack, "json");
	});
	$("#purple").click( function() {
		$.post("changeColorAction.action", {
			color :'purple'
		}, callBack, "json");
	});
	$("#gray").click( function() {
		$.post("changeColorAction.action", {
			color :'gray'
		}, callBack, "json");
	});
	$("#pink").click( function() {
		$.post("changeColorAction.action", {
			color :'pink'
		}, callBack, "json");
	});
	$("#trad").click( function() {
		changeHeader('header.jsp');
	});
	$("#dock").click( function() {
		changeHeader('header_dock.jsp');
	});
	$("#sand").click( function() {
		changeHeader('header_sand.jsp');
	});
	var hovermouse = function() {
		$('#corner img').stop().animate( {
			width :'200px',
			height :'200px'
		});
	}
	var mourseout = function() {
		$('#corner img').stop().animate( {
			width :'80px',
			height :'80px'
		});
	}

	$('#corner img').bind("mouseover", hovermouse);
	$('#corner img').bind("mouseout", mourseout);

	$('#corner img').click( function() {
		$(this).animate( {
			width :viewW,
			height :viewH
		}, 1000, function() {
			changeHeader('header.jsp');
		});
	});

	function changeHeader(header) {
		$('#corner img').unbind("mouseover", hovermouse);
		$('#corner img').unbind("mouseout", mourseout);
		$('#corner img').animate(
				{
					width :viewW,
					height :viewH
				},
				1000,
				function() {
					window.location.href = "changeHeaderAction.action?header="
							+ header;
					$('#corner img').width("80px");
					$('#corner img').height("80px");
					$('#corner img').bind("mouseover", hovermouse);
					$('#corner img').bind("mouseout", mourseout);
				});
	}

})