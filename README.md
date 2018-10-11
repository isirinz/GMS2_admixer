# GMS2_admixer
Game Maker Studio 2 에서 admixer 광고 

# 사용법

애드몹 초기화

GoogleMobileAds_Init("애드몹 전면 광고 unit ID", "애드몹 앱 ID");

상단 배너 노출

admixer_banner("애드믹서에서 받은 key", ADMIXER_BANNER_TOP);

하단 배너 노출

admixer_banner("애드믹서에서 받은 key", ADMIXER_BANNER_BOTTOM);

전면 광고 노출

admixer_interstitial("애드믹서에서 받은 key");
