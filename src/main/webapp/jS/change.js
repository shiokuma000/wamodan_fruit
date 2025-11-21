// change.js
document.addEventListener('DOMContentLoaded', function() {
    const toggle = document.querySelector('.theme-toggle');
    const stylesheet = document.getElementById('theme-stylesheet');

    // 現在のテーマを記憶（localStorage利用でリロード後も保持可能）
    let currentTheme = localStorage.getItem('theme') || 'light';

    // 初期読み込み時に適用
    stylesheet.href = currentTheme === 'dark' ? 'css/wamodan-dark.css' : 'css/wamodern.css';

    toggle.addEventListener('click', () => {
        if(stylesheet.href.includes('wamodern.css')) {
            // ダークテーマに切替
            stylesheet.href = 'css/wamodan-dark.css';
            localStorage.setItem('theme', 'dark');
        } else {
            // ライトテーマに戻す
            stylesheet.href = 'css/wamodern.css';
            localStorage.setItem('theme', 'light');
        }
    });
});
