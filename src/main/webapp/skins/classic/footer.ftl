<#--

    Symphony - A modern community (forum/BBS/SNS/blog) platform written in Java.
    Copyright (C) 2012-present, b3log.org

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.

-->
<div id="footer_web_id" class="footer">
    <div class="wrapper">
        <div class="slogan">
        ${indexIntroLabel} &nbsp;
            <a href="https://www.yuanhaokj.cn" target="_blank" class="tooltipped tooltipped-n"
               aria-label="${siteCodeLabel}">
                <svg class="icon-github">
                    <use xlink:href="#github"></use>
                </svg>
            </a> &nbsp;
        </div>
        <div class="fn-flex-1">
            <div class="footer-nav fn-clear fixed-bottom-nav">
                <a rel="help" href="${servePath}/about">${aboutLabel}</a>
                <a href="${servePath}/tag/announcement">${symAnnouncementLabel}</a>
                <a href="${servePath}/domains">${domainLabel}</a>
                <a href="${servePath}/tags">${tagLabel}</a>
                <a href="${servePath}/statistic">${dataStatLabel}</a>
                <div class="fn-right">
                ${visionLabel}
                </div>
            </div>
            <div class="fn-clear ft-smaller">
            ${sloganLabel}
                <div class="fn-right">
                    <#if footerBeiAnHao != ''>
                        <a href="http://www.beian.miit.gov.cn/" target="_blank">${footerBeiAnHao}</a> •
                    </#if>
                    © ${year} <a href="https://www.yuanhaokj.cn" target="_blank"> 技术论坛 </a>
                    <a href="https://www.yuanhaokj.cn" target="_blank">YuanHaoKJ</a>
                ${version} • ${elapsed?c}ms
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${staticServePath}/js/symbol-defs${miniPostfix}.js?${staticResourceVersion}"></script>
<script src="${staticServePath}/js/lib/compress/libs.min.js?${staticResourceVersion}"></script>
<script src="https://cdn.jsdelivr.net/npm/vditor@1.3.3/dist/index.min.js"></script>
<script src="${staticServePath}/js/common${miniPostfix}.js?${staticResourceVersion}"></script>

<script type="text/javascript">
    $(function(){
        function footerPosition(){
            // $("footer-id").removeClass("fixed-bottom");

            var contentHeight = document.body.scrollHeight;//网页正文全文高度
            var winHeight = window.innerHeight;//可视窗口高度，不包括浏览器顶部工具栏
            if(!(contentHeight > winHeight)){
                //当网页正文高度小于可视窗口高度时，为footer添加类fixed-bottom
                // $("footer-id").addClass("fixed-bottom");
                // $("#footer_web_id").removeClass("footer");
                $(document.body).height("100%");
                $(".main").height("75%");
                // $("#footer_web_id").addClass("fixed-bottom");

                // $(document.html).height("100%");
                // var all_height = $(document.body).height;
                // var footer_height = $("footer-id").height;
                // var pre_height = $(document.body).height - $("footer-id").height;
                // $.prev().height(pre_height);

            } else {
                // $("footer").removeClass("fixed-bottom");
            }
        }
        footerPosition();
        $(window).resize(footerPosition);
    });
</script>

<script>
    var Label = {
        commentEditorPlaceholderLabel: '${commentEditorPlaceholderLabel}',
        langLabel: '${langLabel}',
        markdownHttpAvailable: ${markdownHttpAvailable?c},
        reportSuccLabel: '${reportSuccLabel}',
        breezemoonLabel: '${breezemoonLabel}',
        confirmRemoveLabel: "${confirmRemoveLabel}",
        reloginLabel: "${reloginLabel}",
        invalidPasswordLabel: "${invalidPasswordLabel}",
        loginNameErrorLabel: "${loginNameErrorLabel}",
        followLabel: "${followLabel}",
        unfollowLabel: "${unfollowLabel}",
        symphonyLabel: "${symphonyLabel}",
        visionLabel: "${visionLabel}",
        cmtLabel: "${cmtLabel}",
        collectLabel: "${collectLabel}",
        uncollectLabel: "${uncollectLabel}",
        desktopNotificationTemplateLabel: "${desktopNotificationTemplateLabel}",
        servePath: "${servePath}",
        staticServePath: "${staticServePath}",
        isLoggedIn: ${isLoggedIn?c},
        funNeedLoginLabel: '${funNeedLoginLabel}',
        notificationCommentedLabel: '${notificationCommentedLabel}',
        notificationReplyLabel: '${notificationReplyLabel}',
        notificationAtLabel: '${notificationAtLabel}',
        notificationFollowingLabel: '${notificationFollowingLabel}',
        pointLabel: '${pointLabel}',
        sameCityLabel: '${sameCityLabel}',
        systemLabel: '${systemLabel}',
        newFollowerLabel: '${newFollowerLabel}',
        makeAsReadLabel: '${makeAsReadLabel}',
        <#if isLoggedIn>
            currentUserName: '${currentUser.userName}',
        </#if>
        <#if csrfToken??>
            csrfToken: '${csrfToken}'
        </#if>
    }

    <#if isLoggedIn>
    Label.userKeyboardShortcutsStatus = '${currentUser.userKeyboardShortcutsStatus}'
    </#if>

    Util.init(${isLoggedIn?c})

    <#if isLoggedIn>
    // Init [User] channel
    Util.initUserChannel("${wsScheme}://${serverHost}:${serverPort}${contextPath}/user-channel")
    </#if>

    <#if mouseEffects>
    Util.mouseClickEffects()
    </#if>
</script>
<#if algoliaEnabled>
<script src="${staticServePath}/js/lib/algolia/algolia.min.js"></script>
<script>
    Util.initSearch('${algoliaAppId}', '${algoliaSearchKey}', '${algoliaIndex}')
</script>
</#if>
