import React, { useState } from "react";

export default function LoginForm() {
  const [id, setId] = useState("");
  const [pw, setPw] = useState("");
  const [showPw, setShowPw] = useState(false);
  const [message, setMessage] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    setMessage("");

    // 입력값 유효성 검사
    if (!id || !pw) {
      setMessage("ID와 비밀번호를 모두 입력해주세요.");
      return;
    }

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(id)) {
      setMessage("ID는 이메일 형식으로 입력해주세요.");
      return;
    }

    if (pw.length < 6) {
      setMessage("비밀번호는 최소 6자 이상이어야 합니다.");
      return;
    }

    try {
      const res = await fetch("/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ id, pw }),
      });

      if (!res.ok) throw new Error("로그인 실패");

      const data = await res.json();
      alert("로그인 성공!");
      // 예: 토큰 저장 또는 페이지 이동
    } catch (err) {
      setMessage("로그인에 실패했습니다.");
    }
  };

  return (
    <div className="login-cover">
      <form className="login-wrapper" onSubmit={handleSubmit}>
        <div className="row header">LOGIN</div>

        <div className="row">
          <input
            type="text"
            name="id"
            value={id}
            onChange={(e) => setId(e.target.value)}
            required
          />
          <label>ID (이메일)</label>
          <div className="highlight"></div>
        </div>

        <div className="row">
          <input
            type={showPw ? "text" : "password"}
            name="pw"
            value={pw}
            onChange={(e) => setPw(e.target.value)}
            required
          />
          <label>Password</label>
          <div className="highlight"></div>
        </div>

        <div className="row">
          <label style={{ fontSize: "0.75em" }}>
            <input
              type="checkbox"
              checked={showPw}
              onChange={(e) => setShowPw(e.target.checked)}
            />
            비밀번호 보기
          </label>
        </div>

        <div className="row">
          <button type="submit">login</button>
        </div>

        <div className="row" style={{ fontSize: "0.8em", color: "red" }}>
          {message}
        </div>
      </form>
    </div>
  );
}
