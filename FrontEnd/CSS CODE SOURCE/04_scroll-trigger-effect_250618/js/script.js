$(function () {
  gsap.registerPlugin(ScrollTrigger);

  // 01. visual 영역에 스크롤 트리거 및 애니메이션 적용
  gsap
    .timeline({
      scrollTrigger: {
        trigger: ".visual", // 트리거 대상
        start: "top top", // 뷰포트와 트리거가 모두 top에 닿을 때 시작
        end: "bottom top", // 트리거 하단이 뷰포트 상단에 닿을 때 종료
        scrub: 1, // 부드러운 스크러빙
        pin: true, // 해당 섹션 고정
        markers: true, // 디버그용 마커 표시
      },
    })
    .to(
      ".visual h1",
      {
        opacity: "1",
        ease: "none",
        duration: "10",
      },
      5
    ) // 5초 후 시작

    .to(
      ".visual img",
      {
        scale: "0.4",
        ease: "none",
        duration: "10",
        opacity: "0.3",
      },
      5
    ); // 같은 타이밍(5초 후)에 시작

  // 02. imgBox
  gsap.utils.toArray(".imgBox").forEach(function (imgBox) {
    // toArray()=> 인트턴스를 배열로 만드는 메소드이며, forEach() => 배열을 반복문으로 사용하는 메소드
    gsap.timeline({
      scrollTrigger: {
        trigger: imgBox,
        start: "50% 100%",
        toggleClass: { targets: imgBox, className: "active" },
        scrub: 1,
        // markers: true,
      },
    });
  });

  // 03.textBox
  gsap.utils.toArray(".textBox").forEach(function (textBox) {
    gsap.timeline({
      scrollTrigger: {
        trigger: textBox,
        start: "50% 80%",
        end: "100% 0%",
        toggleClass: { targets: textBox, className: "active" },
        scrub: 1,
        markers: true,
      },
    });
  });
});
