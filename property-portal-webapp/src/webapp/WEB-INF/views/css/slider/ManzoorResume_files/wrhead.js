function opnWin(url,iW,iH,sWN,fTB,fAB,fMB){if(!sWN)sWN=new String(Math.round(Math.random()*1000000));if(!iW)iW=700;if(!iH)iH=500;var iTB=0;if(fTB)iTB=1;var iAB=0;if(fAB)iAB=1;var iMB=0;if(fMB)iMB=1;var sF="toolbar="+iTB+",location="+iAB+",directories=0,status=1,menubar="+iMB+",scrollbars=1,resizable=1,width="+iW+",height="+iH;return window.open(url,sWN,sF)}function opnHlp(url){var oWin=opnWin(url,a_iHW,a_iHH,a_sHWN,1,1,1);try{oWin.focus()}catch(e){}}function rldBdFrm(iPn){parent.document.getElementById("frabody").src=a_sLocHref+iPn}function adjHght(){var o=document.getElementById("divbml");parent.document.getElementById("frsmain").rows=(o.offsetTop+o.offsetHeight)+",*"}function onClkAtmt(iLvl){if(iLvl=="2"){alert(a_sL2Aw);return false}else if(iLvl=="3"){return true}}var g_iCpn=1;var g_iTpn=0;var g_fInpcs=1;function clkPgBtn(o){if(parent.document.getElementById("frabody").contentWindow==null||g_fInpcs)return;if(((o.id=="lnkfst"||o.id=="lnkpre")&&a_fPbs==0)||((o.id=="lnknxt"||o.id=="lnklst")&&a_fNbs==0))return;g_fInpcs=1;if(o.id=="lnkfst")g_iCpn=1;else if(o.id=="lnkpre")g_iCpn=g_iCpn-1;else if(o.id=="lnknxt")g_iCpn=g_iCpn+1;else if(o.id=="lnklst")g_iCpn=0;rldBdFrm(g_iCpn)}function onPrn(){if(a_fPrntDsbl==1){return}var oBodyWindow=parent.document.getElementById("frabody").contentWindow;if(oBodyWindow==null)return;oBodyWindow.focus();oBodyWindow.print()}function onKPCp(e){if(e.keyCode==13){if(g_fInpcs==0){var iRpn=parseInt(document.getElementById("txtcp").value,10);if(!isNaN(iRpn)&&iRpn>0&&iRpn<=g_iTpn){g_fInpcs=1;rldBdFrm(iRpn)}}return false}}function initFrm(){if(parent==self){document.location=a_sWrdvHref;return}parent.document.title=document.title;if(a_fIsBasic)window.setTimeout("adjHght()",200);else adjHght();rldBdFrm("1")}window.onload=initFrm;window.onresize=adjHght;