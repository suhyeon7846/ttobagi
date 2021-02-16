window.addEventListener("load",()=>{
	let editorContent = CKEDITOR.instances.editor.getData();
	let convertContent = editorContent.replace(/(<([^>]+)>)/ig,"");
	
});